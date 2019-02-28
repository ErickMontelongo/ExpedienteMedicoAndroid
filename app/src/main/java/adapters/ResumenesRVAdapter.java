package adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import activities.R;
import activities.historialActivities.PdfViewActivity;
import dataholders.Resumencirugia;

/**
 * Created by Punkid PC on 28/01/2017.
 */

public class ResumenesRVAdapter extends RecyclerView.Adapter<ResumenesRVAdapter.ResumenViewHolder> {

    List<Resumencirugia> archivos;

    public ResumenesRVAdapter(List<Resumencirugia> archivos){
        this.archivos = archivos;
    }

    @Override
    public ResumenesRVAdapter.ResumenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_historial_archivos_cards, parent, false);
       ResumenViewHolder rvh = new ResumenViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(ResumenesRVAdapter.ResumenViewHolder holder, int position) {
        holder._rutaArchivo.setText(archivos.get(position).getRuta().substring(archivos.get(position).getRuta().lastIndexOf('/')));
        holder.setArchivo(archivos.get(position));
    }

    @Override
    public int getItemCount() {
        return archivos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }





    public static class ResumenViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView _rutaArchivo;
        Resumencirugia archivo;
        static View innerView;

        ResumenViewHolder(final View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.archivo_cv);
            _rutaArchivo = (TextView) itemView.findViewById(R.id.archivo_nombre);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    innerView = itemView;
                    openPdf();
                }
            });
        }

        public void setArchivo(Resumencirugia a){
            archivo = a;
        }

        private void openPdf(){
            Intent i = new Intent(innerView.getContext(), PdfViewActivity.class);
            i.putExtra("ruta", archivo.getRuta());
            innerView.getContext().startActivity(i);
        }
    }
}
