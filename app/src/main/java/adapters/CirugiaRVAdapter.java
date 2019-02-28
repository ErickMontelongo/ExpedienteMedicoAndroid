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

import java.util.ArrayList;
import java.util.List;

import activities.R;
import activities.historialActivities.HistorialResumenActivity;
import dataholders.Cirugias;
import dataholders.Resumencirugia;

/**
 * Created by Punkid PC on 28/01/2017.
 */

/**
 * Adaptador de Cards para representar las cirugias de un paciente
 */
public class CirugiaRVAdapter  extends RecyclerView.Adapter<CirugiaRVAdapter.CirugiaViewHolder> implements Filterable{

    List<Cirugias> originalCirugias;
    List<Cirugias> filteredCirugias;
    private FiltroCirugia filtroCirugia;

    public CirugiaRVAdapter (List<Cirugias> cirugias){
        filteredCirugias = new ArrayList<>();
        originalCirugias = cirugias;
        filteredCirugias.addAll(originalCirugias);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CirugiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_historial_cirugias_cards, parent, false);
        CirugiaViewHolder cvh = new CirugiaViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CirugiaViewHolder holder, int position) {
        holder._nombre.setText(filteredCirugias.get(position).getNombreOperacion());
        holder._clinica.setText("Clinica: "+filteredCirugias.get(position).getClinica());
        holder._fecha.setText("Fecha de cirugía: "+filteredCirugias.get(position).getFecha().toString());
        holder.setCirugia(filteredCirugias.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredCirugias.size();
    }

    @Override
    public Filter getFilter() {
        if(filtroCirugia == null)
            return filtroCirugia = new FiltroCirugia(this, originalCirugias);
        return filtroCirugia;
    }


    public static class CirugiaViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView _nombre;
        TextView _clinica;
        TextView _fecha;
        static View innerView;
        Cirugias cirugia;

        CirugiaViewHolder(final View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cirugia_cv);
            _nombre = (TextView) itemView.findViewById(R.id.cirugia_nombre);
            _clinica = (TextView) itemView.findViewById(R.id.cirugia_clinica);
            _fecha = (TextView) itemView.findViewById(R.id.cirugia_fecha);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    innerView = itemView;
                    callArchivosMedicos(v);
                }
            });
        }

        public void setCirugia(Cirugias c){
            cirugia = c;
        }

        private void callArchivosMedicos(View v){
            Intent i = new Intent(innerView.getContext(), HistorialResumenActivity.class);
            i.putExtra("archivos", (ArrayList<Resumencirugia>) cirugia.getResumencirugiaCollection());
            innerView.getContext().startActivity(i);
        }


    }

    private static class FiltroCirugia extends Filter {

        private final CirugiaRVAdapter adapter;
        private final List<Cirugias> originalList;
        private final List<Cirugias> filteredList;

        private FiltroCirugia(CirugiaRVAdapter adapter, List<Cirugias> originalList){
            super();
            this.adapter = adapter;
            this.originalList = originalList;
            filteredList = new ArrayList<>();
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

                for(final Cirugias cirugia: originalList){
                    if(cirugia.getNombreOperacion().toLowerCase().contains(filterPattern))
                        filteredList.add(cirugia);
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            adapter.filteredCirugias.clear();
            adapter.filteredCirugias.addAll((ArrayList<Cirugias>) results.values);
            adapter.notifyDataSetChanged();
        }

    }

}
