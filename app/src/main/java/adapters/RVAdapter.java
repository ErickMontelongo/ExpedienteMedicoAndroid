package adapters;

/**
 * Created by Punkid PC on 12/11/2016.
 */

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import WebServicesUtils.ExpedienteUtilsRestClient;
import WebServicesUtils.PacienteRestClient;
import activities.R;
import activities.ResumenActivity;
import cz.msebera.android.httpclient.Header;
import dataholders.Paciente;
import dataholders.Permisos;
import dataholders.ShowPaciente;

/**
 * Adaptador de Cards que representan los pacientes asignados a un médico
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> implements Filterable{

    List<ShowPaciente> pacientes;
    List<ShowPaciente> pacientesFiltered;
    private FiltroPacientes filtroPacientes;
    private static int idMedico;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_paciente_cards, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.personName.setText(pacientesFiltered.get(position).nombre +" "+ pacientesFiltered.get(position).apellidoP +" "+ pacientesFiltered.get(position).apellidoM);
        holder.personCurp.setText("Curp: "+pacientesFiltered.get(position).curp);

    }

    @Override
    public int getItemCount() {
        return pacientesFiltered.size();
    }

    @Override
    public Filter getFilter() {
        if(filtroPacientes == null)
            return filtroPacientes = new FiltroPacientes(this,pacientes);
        return filtroPacientes;
    }


    public static class PersonViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView personName;
        TextView personCurp;
        static View innerView;
        ImageView personPhoto;
        static Permisos permisosA = new Permisos();
        static Paciente pacienteA = new Paciente();

        PersonViewHolder(final View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personCurp = (TextView)itemView.findViewById(R.id.person_curp);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                innerView = itemView;
                getPermisos();
                }
            });
        }

        private static void setPermisos(Permisos p){
            permisosA = p;
        }

        private static void setPaciente(Paciente p){
            pacienteA = p;
        }

        private void getPermisos(){
            RequestParams request = new RequestParams();
            request.add("id", String.valueOf(idMedico));
            request.add("curp", String.valueOf(personCurp.getText()).substring(6));

            ExpedienteUtilsRestClient.get("getPermisos/", request, new JsonHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    ObjectMapper mapper = new ObjectMapper();
                    Permisos permisos = null;
                    try{
                        permisos = mapper.readValue(response.toString(), Permisos.class);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    permisosA = permisos;
                    getPaciente();

                }
            });
        }

        private void getPaciente(){
            RequestParams request = new RequestParams();
            request.add("id", String.valueOf(String.valueOf(personCurp.getText()).substring(6)));

            PacienteRestClient.getPacientesForShow("getByIdPaciente/", request, new JsonHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    ObjectMapper mapper = new ObjectMapper();
                    Paciente paciente = null;
                    try{
                        paciente = mapper.readValue(response.toString(), Paciente.class);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    pacienteA = paciente;
                    startActivity();


                }
            });
            }

        private static void startActivity(){
            Intent intent = new Intent(innerView.getContext(), ResumenActivity.class);
            intent.putExtra("paciente", pacienteA);
            intent.putExtra("permisos", permisosA);
            innerView.getContext().startActivity(intent);
        }



    }

    private static class FiltroPacientes extends Filter{

        private final RVAdapter adapter;
        private final List<ShowPaciente> originalList;
        private final List<ShowPaciente> filteredList;

        private FiltroPacientes(RVAdapter adapter, List<ShowPaciente> originalList){
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

                for(final ShowPaciente paciente: originalList){
                    if(paciente.nombre.toLowerCase().contains(filterPattern))
                        filteredList.add(paciente);
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            adapter.pacientesFiltered.clear();
            adapter.pacientesFiltered.addAll((ArrayList<ShowPaciente>) results.values);
            adapter.notifyDataSetChanged();
        }
    }


    public void setIdMedico(int id){
        idMedico = id;
    }


    public RVAdapter(List<ShowPaciente> pacientes){
        this.pacientes = pacientes;
        pacientesFiltered = new ArrayList<>();
        pacientesFiltered.addAll(pacientes);
    }


}
