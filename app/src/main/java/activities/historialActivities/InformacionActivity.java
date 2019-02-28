package activities.historialActivities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import activities.R;
import butterknife.ButterKnife;
import butterknife.InjectView;
import dataholders.Informacionpersonal;

/**
 * Created by Punkid PC on 26/01/2017.
 */

/**
 * Actividad que se encarga de presentar la información personal de un pacietne.
 */
public class InformacionActivity extends AppCompatActivity {

    @InjectView(R.id.historial_informacion_sexo)
    TextView _sexo;
    @InjectView(R.id.historial_informacion_fechaNac)
    TextView _fechaNac;
    @InjectView(R.id.historial_informacion_altura)
    TextView _altura;
    @InjectView(R.id.historial_informacion_peso)
    TextView _peso;
    @InjectView(R.id.historial_informacion_tipoSangre)
    TextView _tipoSangre;
    @InjectView(R.id.historial_informacion_transfuciones)
    TextView _transfuciones;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    private Informacionpersonal informacion = new Informacionpersonal();


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_informacion);
        ButterKnife.inject(this);
        toolbar.setTitle("Informacion Personal");
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
            informacion = (Informacionpersonal) extras.get("informacion");

        _sexo.setText(informacion.getSexo());
        _fechaNac.setText(informacion.getFechaNac().toString());
        _altura.setText(String.valueOf(informacion.getAltura())+"m");
        _peso.setText(String.valueOf(informacion.getPeso())+"Kg");
        _tipoSangre.setText(informacion.getTipoSangre());
        if(informacion.getTransfuciones())
            _transfuciones.setText("SI");
        else
            _transfuciones.setText("NO");

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
                .setName("Informacion Page") // TODO: Define a title for the content shown.
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
}
