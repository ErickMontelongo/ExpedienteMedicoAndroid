package activities;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.net.URL;

import butterknife.ButterKnife;
import butterknife.InjectView;
import dataholders.Estudiosmedicos;

/**
 * Created by Punkid PC on 24/11/2016.
 */

/**
 * Actividad que se encarga de presentar la interfaz para visualizar el estudio médico de un paciente.
 */
public class EstudioImageActivity extends AppCompatActivity {

    @InjectView(R.id.estudio_imageView)
    ImageView _imageView;
    @InjectView(R.id.estudio_resumen_nombre)
    TextView _nombreEstudio;
    @InjectView(R.id.estudio_resumen_medico) TextView _medicoEstudio;
    @InjectView(R.id.estudio_resumen_clinica) TextView _clinicaEstudio;
    @InjectView(R.id.estudio_resumen_interpretacion) TextView _interpretacionEstudio;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    Estudiosmedicos estudio = new Estudiosmedicos();

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_estudio);
        ButterKnife.inject(this);
        toolbar.setTitle("Visualizar estudio");
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            estudio = (Estudiosmedicos) extras.get("estudio");
        }

        new getImageFromURL().execute(estudio.getRutaImagen());

        _nombreEstudio.setText(estudio.getDatosEstudiosMedicosidDatosEstudiosMedicos().getNombreEstudio());
        _medicoEstudio.setText("Realizado por: "+estudio.getDatosEstudiosMedicosidDatosEstudiosMedicos().getNombreMedico());
        _clinicaEstudio.setText("Clinica resonsable: "+estudio.getDatosEstudiosMedicosidDatosEstudiosMedicos().getNombreClinica());
        _interpretacionEstudio.setText(estudio.getDatosEstudiosMedicosidDatosEstudiosMedicos().getInterpretacion());

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("EstudioImage Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    /**
     * Clase que implementa una tarea asíncrona para poder cargar en el hilo principal de la aplicación una imagen obtenida desde el servidor.
     */
    private class getImageFromURL extends AsyncTask<String, Void, Drawable>{

        @Override
        protected Drawable doInBackground(String... params) {
            try {
                URL is = new URL(params[0]);
                Drawable d = Drawable.createFromStream(is.openStream(), "src name");
                return d;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Drawable result){
            _imageView.setImageDrawable(result);
        }
    }

}
