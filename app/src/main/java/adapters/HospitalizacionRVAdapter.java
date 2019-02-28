package adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import activities.R;

import java.util.ArrayList;
import java.util.List;

import activities.historialActivities.HistorialArchivosActivity;
import dataholders.Archivosmedicos;
import dataholders.Hospitalizacion;

/**
 * Created by Punkid PC on 27/01/2017.
 */

public class HospitalizacionRVAdapter extends RecyclerView.Adapter<HospitalizacionRVAdapter.HospitalizacionViewHolder> implements Filterable {

    List<Hospitalizacion> originalHospitalizacion;
    List<Hospitalizacion> filteredHospitalizacion;
    private FiltroHospitalizacion filtroHospitalizacion;

    public HospitalizacionRVAdapter(List<Hospitalizacion> hospitalizaciones){
        filteredHospitalizacion = new ArrayList<>();
        originalHospitalizacion = hospitalizaciones;
        filteredHospitalizacion.addAll(originalHospitalizacion);
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public HospitalizacionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_historial_hospitalizacion_cards, parent, false);
        HospitalizacionViewHolder hvh = new HospitalizacionViewHolder(v);
        return hvh;
    }

    @Override
    public void onBindViewHolder(HospitalizacionViewHolder holder, int position) {
        holder._causa.setText(filteredHospitalizacion.get(position).getCausa());
        holder._clinica.setText("Clínica: "+filteredHospitalizacion.get(position).getClinica());
        holder._ingreso.setText("Fecha de ingreso: "+filteredHospitalizacion.get(position).getFechaIngreso().toString());
        holder._salida.setText("Fecha de salida: "+filteredHospitalizacion.get(position).getFechaSalida().toString());
        holder.setHospitalizacion(filteredHospitalizacion.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredHospitalizacion.size();
    }

    @Override
    public Filter getFilter() {
       if(filtroHospitalizacion == null)
           return  filtroHospitalizacion = new FiltroHospitalizacion(this, originalHospitalizacion);
        return filtroHospitalizacion;
    }

    public static class HospitalizacionViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView _causa;
        TextView _clinica;
        TextView _ingreso;
        TextView _salida;
        static View innerView;
        Hospitalizacion hospitalizacion;

        HospitalizacionViewHolder(final View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.hospitalizacion_cv);
            _causa = (TextView) itemView.findViewById(R.id.hospitalizacion_causa);
            _clinica = (TextView) itemView.findViewById(R.id.hospitalizacion_clinica);
            _ingreso = (TextView) itemView.findViewById(R.id.hospitalizacion_fechaIngreso);
            _salida = (TextView) itemView.findViewById(R.id.hospitalizacion_fechaSalida);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    innerView = itemView;
                    callArchivosMedicos(v);
                }
            });
        }

        public void setHospitalizacion(Hospitalizacion h){
            hospitalizacion = h;
        }

        private void callArchivosMedicos(View view){
            Intent i = new Intent(innerView.getContext(), HistorialArchivosActivity.class);
            i.putExtra("archivos", (ArrayList<Archivosmedicos>)hospitalizacion.getArchivosmedicosCollection());
            innerView.getContext().startActivity(i);
        }

    }

    private static class FiltroHospitalizacion extends Filter{

        private final HospitalizacionRVAdapter adapter;
        private final List<Hospitalizacion> originalList;
        private final List<Hospitalizacion> filteredList;

        private FiltroHospitalizacion(HospitalizacionRVAdapter adapter, List<Hospitalizacion> originalList){
            super();
            this.adapter = adapter;
            this.originalList = originalList;
            this.filteredList = new ArrayList<>();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            filteredList.clear();
            final FilterResults results = new FilterResults();

            if(constraint.length() == 0){
                filteredList.addAll(originalList);
            }
            else{
                final String filterPattern = constraint.toString().toLowerCase().trim();

                for(final Hospitalizacion hospitalizacion: originalList){
                    if(hospitalizacion.getCausa().toLowerCase().contains(filterPattern))
                        filteredList.add(hospitalizacion);
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            adapter.filteredHospitalizacion.clear();
            adapter.filteredHospitalizacion.addAll((ArrayList<Hospitalizacion>) results.values);
            adapter.notifyDataSetChanged();
        }
    }
}
