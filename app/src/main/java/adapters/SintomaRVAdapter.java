package adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.List;

import activities.R;
import activities.ResumenActivity;
import dataholders.Sintoma;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Punkid PC on 23/11/2016.
 */

/**
 * Adaptador de Cards que representan los síntomas de un paciente
 */
public class SintomaRVAdapter extends RecyclerView.Adapter<SintomaRVAdapter.SintomaViewHolder> {

    List<Sintoma> sintomas;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public SintomaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sintoma_cards, parent, false);
        SintomaViewHolder svh = new SintomaViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(SintomaViewHolder holder, int position) {
        holder._sintomaTitulo.setText(sintomas.get(position).getNombre());
        holder._SintomaFecha.setText("Inicio:"+sintomas.get(position).getDateInicio()+"     Fin:"+sintomas.get(position).getDateFin());
        holder.setSintoma(sintomas.get(position));

    }

    @Override
    public int getItemCount() {
        return sintomas.size();
    }

    public static class SintomaViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView _sintomaTitulo;
        TextView _SintomaFecha;
        Sintoma sintoma;

        SintomaViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.sintoma_cv);
            _sintomaTitulo = (TextView) itemView.findViewById(R.id.sintoma_titulo);
            _SintomaFecha = (TextView) itemView.findViewById(R.id.sintoma_fecha);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    createPopUp(v);
                }
            });

        }

        public void setSintoma(Sintoma s){
            sintoma = s;
        }

        private void createPopUp(View view){
            LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View customView = inflater.inflate(R.layout.sintoma_popup, null);

            TextView text = (TextView) customView.findViewById(R.id.sintoma_popupText);
            TextView titulo = (TextView) customView.findViewById(R.id.sintoma_popup_titulo);
            TextView intensidad = (TextView) customView.findViewById(R.id.sintoma_popup_intensidad);
            TextView frecuencia = (TextView) customView.findViewById(R.id.sintoma_popup_frecuencia);
            TextView regionCuerpo = (TextView) customView.findViewById(R.id.sintoma_popup_regionCuerpo);
            TextView regionEspecifica = (TextView) customView.findViewById(R.id.sintoma_popup_regionEspecifica);
            TextView descripcion = (TextView) customView.findViewById(R.id.sintoma_popup_descripcion);

            text.setText("Resumen de sintomas");
            titulo.setText(sintoma.getNombre());
            intensidad.setText("Intensidad: "+sintoma.getDescripcionSintomaidDescripcionSintoma().getIntensidad());
            frecuencia.setText("Frecuencia: "+sintoma.getDescripcionSintomaidDescripcionSintoma().getFrecuencia());
            regionCuerpo.setText("Región del cuerpo: "+sintoma.getDescripcionSintomaidDescripcionSintoma().getRegionCuerpo());
            regionEspecifica.setText("Región específica: "+sintoma.getDescripcionSintomaidDescripcionSintoma().getRegionEspecifica());
            descripcion.setText("Descripción: "+sintoma.getDescripcionSintomaidDescripcionSintoma().getDescripcion());

            final PopupWindow popupWindow = new PopupWindow(customView, RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
            popupWindow.setElevation(0.5f);
            ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);
            closeButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });

            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        }

    }

    public SintomaRVAdapter(List<Sintoma> sintomas){
        this.sintomas = sintomas;
    }
}


