package activities.historialActivities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import activities.R;
import butterknife.ButterKnife;
import butterknife.InjectView;
import dataholders.Antecedentes;

/**
 * Created by Punkid PC on 27/01/2017.
 */

/**
 * Actividad que se encarga de presentar los antecedentes familiares de la historia clínica de un paciente
 */
public class AntecedentesActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    private ArrayList<Antecedentes> antecedentes;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_muestrainfo);
        ButterKnife.inject(this);
        toolbar.setTitle("Antecedentes del paciente");
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
            antecedentes = (ArrayList<Antecedentes>) extras.get("antecedentes");

        ViewGroup rootView = (ViewGroup) findViewById(R.id.contenedor_padre);

        for(Antecedentes a: antecedentes){
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.historial_muestrainformacion, rootView, false);
            TextView _nombre = (TextView) view.findViewById(R.id.historial_antecedentes_familiar);
            TextView _vivo = (TextView) view.findViewById(R.id.historial_antecedentes_vivo);
            TextView _causa = (TextView) view.findViewById(R.id.historial_antecedentes_causa);

            _nombre.setText(a.getFamiliar());
            if(a.getVivo())
                _vivo.setText("Vivo");
            else
                _vivo.setText("Muerto");
            _causa.setText(a.getCausa());

            rootView.addView(view);
        }

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
                .setName("Antecedentes Page") // TODO: Define a title for the content shown.
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
