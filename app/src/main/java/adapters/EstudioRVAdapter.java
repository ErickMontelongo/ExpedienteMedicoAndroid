package adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import activities.EstudioImageActivity;
import activities.R;
import dataholders.Estudiosmedicos;

/**
 * Created by Punkid PC on 24/11/2016.
 */

/**
 * Adaptador de las Cards que representan los estudios de laboratorio de un paciente
 */
public class EstudioRVAdapter extends RecyclerView.Adapter<EstudioRVAdapter.EstudioViewHolder> {

    private List<Estudiosmedicos> estudios;


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public EstudioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_estudio_cards, parent, false);
        EstudioViewHolder evh = new EstudioViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(EstudioViewHolder holder, int position) {
        holder._nombreEstudio.setText(estudios.get(position).getDatosEstudiosMedicosidDatosEstudiosMedicos().getNombreEstudio());
        holder._categoriaEstudio.setText(estudios.get(position).getDatosEstudiosMedicosidDatosEstudiosMedicos().getCategoriaEstudio());
        holder._fechaEstudio.setText(estudios.get(position).getFechaEstudio().toString());
        holder.setEstudio(estudios.get(position));

    }

    @Override
    public int getItemCount() {
        return estudios.size();
    }

    public static class EstudioViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView _nombreEstudio;
        TextView _categoriaEstudio;
        TextView _fechaEstudio;
        Estudiosmedicos estudio;

        EstudioViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.estudio_cv);
            _nombreEstudio = (TextView) itemView.findViewById(R.id.estudio_nombre);
            _categoriaEstudio = (TextView) itemView.findViewById(R.id.estudio_categoria);
            _fechaEstudio = (TextView) itemView.findViewById(R.id.estudio_fecha);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), EstudioImageActivity.class);
                    i.putExtra("estudio", estudio);
                    v.getContext().startActivity(i);
                }
            });
        }


        public void setEstudio(Estudiosmedicos e){
            estudio = e;
        }


        }

    public EstudioRVAdapter(List<Estudiosmedicos> e){
        estudios = e;
    }
}
