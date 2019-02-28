package adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import activities.R;
import dataholders.Medicamento;
import dataholders.Prescripcion;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.content.Context.TELECOM_SERVICE;

/**
 * Created by Punkid PC on 26/01/2017.
 */

/**
 * Adaptador de Cards que representan los medicamentos de un paciente.
 */
public class MedicamentoRVAdapter extends RecyclerView.Adapter<MedicamentoRVAdapter.MedicamentoViewHolder> implements Filterable {

    List<Prescripcion> prescripciones;
    List<Medicamento> originalMedicamentos;
    List<Medicamento> filteredMedicamentos;
    private FiltroMedicamentos filtroMedicamentos;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MedicamentoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_medicamentos_cards, parent, false);
        MedicamentoViewHolder mvh = new MedicamentoViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MedicamentoViewHolder holder, int position) {
        holder._nombreGenerico.setText("Nombre genérico: "+filteredMedicamentos.get(position).getNombreGenerico());
        holder._nombreComercial.setText("Nombre comercial: "+filteredMedicamentos.get(position).getNombreComercial());
        holder._concentracion.setText("Concentracion: "+filteredMedicamentos.get(position).getConcentracion());
        if(filteredMedicamentos.get(position).getActivo())
            holder._medicamentoActivo.setText("Medicamento activo: SI");
        else
            holder._medicamentoActivo.setText("Medicamento activo: NO");
        holder._fecha.setText("Fecha de inicio de tratamiento: "+filteredMedicamentos.get(position).getPrescripcionidPrescripcion().getFecha().toString());
        holder.setMedicamento(filteredMedicamentos.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredMedicamentos.size();
    }

    @Override
    public Filter getFilter() {
        if(filtroMedicamentos == null)
            return filtroMedicamentos = new FiltroMedicamentos(this, originalMedicamentos);
        return filtroMedicamentos;
    }

    public static class MedicamentoViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView _nombreGenerico;
        TextView _nombreComercial;
        TextView _concentracion;
        TextView _medicamentoActivo;
        TextView _fecha;
        Medicamento medicamento;

        MedicamentoViewHolder (View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.medicamento_cv);
            _nombreGenerico = (TextView) itemView.findViewById(R.id.medicamento_nombreGenerico);
            _nombreComercial = (TextView) itemView.findViewById(R.id.medicamento_nombreComercial);
            _concentracion = (TextView) itemView.findViewById(R.id.medicamento_concentracion);
            _medicamentoActivo = (TextView) itemView.findViewById(R.id.medicamento_concentracion);
            _fecha = (TextView) itemView.findViewById(R.id.medicamento_fecha);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    createPopUp(v);
                }
            });
        }

        public void setMedicamento(Medicamento m){
            medicamento = m;
        }

        private void createPopUp(View view){
            LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View customView = inflater.inflate(R.layout.medicamento_popup, null);

            TextView nombreGenerico = (TextView)customView.findViewById(R.id.medicamento_popup_titulo);
            TextView nombreComercial = (TextView)customView.findViewById(R.id.medicamento_popup_nombreComercial);
            TextView duracion = (TextView)customView.findViewById(R.id.medicamento_popup_duracion);
            TextView frecuencia = (TextView)customView.findViewById(R.id.medicamento_popup_frecuencia);
            TextView lunes = (TextView)customView.findViewById(R.id.medicamento_popup_lunes);
            TextView martes = (TextView)customView.findViewById(R.id.medicamento_popup_martes);
            TextView miercoles = (TextView)customView.findViewById(R.id.medicamento_popup_miercoles);
            TextView jueves = (TextView)customView.findViewById(R.id.medicamento_popup_jueves);
            TextView viernes = (TextView)customView.findViewById(R.id.medicamento_popup_viernes);
            TextView sabado = (TextView)customView.findViewById(R.id.medicamento_popup_sabado);
            TextView domingo = (TextView)customView.findViewById(R.id.medicamento_popup_domingo);
            TextView alergia = (TextView)customView.findViewById(R.id.medicamento_popup_alergia);
            TextView adversas = (TextView)customView.findViewById(R.id.medicamento_popup_adversas);
            TextView resultados = (TextView)customView.findViewById(R.id.medicamento_popup_resultados);

            nombreGenerico.setText(medicamento.getNombreGenerico());
            nombreComercial.setText("Nombre comercial: "+medicamento.getNombreComercial());
            duracion.setText("Duración: "+medicamento.getInstruccionesIngestaidInstruccionesIngesta().getDuracion());
            frecuencia.setText("Frecuencia: "+medicamento.getInstruccionesIngestaidInstruccionesIngesta().getFrecuencia());
            lunes.setText("Ingesa de día Lunes: "+medicamento.getInstruccionesIngestaidInstruccionesIngesta().getLunes());
            martes.setText("Ingesta de día Martes: "+medicamento.getInstruccionesIngestaidInstruccionesIngesta().getMartes());
            miercoles.setText("Ingesta de día Miercoles: "+medicamento.getInstruccionesIngestaidInstruccionesIngesta().getMiercoles());
            jueves.setText("Ingesta de día Jueves: "+medicamento.getInstruccionesIngestaidInstruccionesIngesta().getJueves());
            viernes.setText("Ingesta de día Viernes: "+medicamento.getInstruccionesIngestaidInstruccionesIngesta().getViernes());
            sabado.setText("Ingesta de día Sábado: "+medicamento.getInstruccionesIngestaidInstruccionesIngesta().getSabado());
            domingo.setText("Ingesta de día Domingo: "+medicamento.getInstruccionesIngestaidInstruccionesIngesta().getDomingo());
            if(medicamento.getAlergia())
                alergia.setText("Alergia presentada: SI");
            else
                alergia.setText("Alergia presentada: NO");
            adversas.setText("Reacciones adversas: "+medicamento.getReaccionesAdversas());
            resultados.setText("Resultados: "+medicamento.getResultadoUso());


            final PopupWindow popupWindow = new PopupWindow(customView, RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
            popupWindow.setElevation(0.5f);
            ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close_medicamentos);
            closeButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });

            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        }

    }

    private static class FiltroMedicamentos extends Filter{

        private final MedicamentoRVAdapter adapter;
        private final List<Medicamento> originalList;
        private final List<Medicamento> filteredList;

        private FiltroMedicamentos(MedicamentoRVAdapter adapter, List<Medicamento> originalList){
            super();
            this.adapter = adapter;
            this.originalList = originalList;
            this.filteredList = new ArrayList<>();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint){
            filteredList.clear();
            final FilterResults results = new FilterResults();

            if(constraint.length() == 0){
                filteredList.addAll(originalList);
            }
            else{
                final String filterPattern = constraint.toString().toLowerCase().trim();

                for(final Medicamento medicamento: originalList){
                    if(medicamento.getNombreGenerico().toLowerCase().contains(filterPattern))
                        filteredList.add(medicamento);
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results){
            adapter.filteredMedicamentos.clear();
            adapter.filteredMedicamentos.addAll((ArrayList<Medicamento>) results.values);
            adapter.notifyDataSetChanged();
        }

    }

    public MedicamentoRVAdapter(List<Prescripcion> p){
        this.prescripciones = p;
        originalMedicamentos = new ArrayList<>();
        filteredMedicamentos = new ArrayList<>();
        for(Prescripcion pres: prescripciones){
            ArrayList<Medicamento> med = (ArrayList<Medicamento>) pres.getMedicamentoCollection();
            for(Medicamento m: med){
                m.setPrescripcionidPrescripcion(pres);
                originalMedicamentos.add(m);
            }
        }
        filteredMedicamentos.addAll(originalMedicamentos);
    }

}
