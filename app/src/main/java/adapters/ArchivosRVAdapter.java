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
import dataholders.Archivosmedicos;

/**
 * Created by Punkid PC on 27/01/2017.
 */

/**
 * Adaptador de Cards para la visualización de archivos médicos
 */
public class ArchivosRVAdapter extends RecyclerView.Adapter<ArchivosRVAdapter.ArchivosViewHolder>{

    List<Archivosmedicos> archivos;

    public ArchivosRVAdapter(List<Archivosmedicos> archivos){
        this.archivos = archivos;
    }


    @Override
    public ArchivosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_historial_archivos_cards, parent, false);
        ArchivosViewHolder pvh = new ArchivosViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ArchivosViewHolder holder, int position) {
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




    public static class ArchivosViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView _rutaArchivo;
        Archivosmedicos archivo;
        static View innerView;

        ArchivosViewHolder(final View itemView){
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

        public void setArchivo(Archivosmedicos a){
            archivo = a;
        }

        private void openPdf(){
            Intent i = new Intent(innerView.getContext(), PdfViewActivity.class);
            i.putExtra("ruta", archivo.getRuta());
            innerView.getContext().startActivity(i);
        }
    }
}
