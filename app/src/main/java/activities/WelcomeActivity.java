package activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import WebServicesUtils.PacienteRestClient;
import butterknife.ButterKnife;
import butterknife.InjectView;
import cz.msebera.android.httpclient.Header;
import dataholders.Medico;
import dataholders.ShowPaciente;

/**
 * Created by Punkid PC on 11/11/2016.
 */

/**
 * Actividad que se encarga de presentar en pantalla la bienvenida al médico despues de un ingreso exitoso al sistema
 */
public class WelcomeActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @InjectView(R.id.textView_bienvenido) TextView _textBienvenido;
    @InjectView(R.id.btn_pacientes) Button _btnBienvenido;
    @InjectView(R.id.textView_resumen) TextView _textResumen;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    Medico medico = new Medico();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);
        toolbar.setTitle("Bienvenido");
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            medico = (Medico) extras.get("medico");
        }

        _textResumen.setText("Bienvenido "+medico.getNombre()+" "+medico.getApellidoP()+" "+medico.getApellidoM()+"\n"+
        "Empresa: "+medico.getDireccionTrabajoidDireccionTrabajo().getNombreEmpresa()+"\n"+
        "Consultorio: "+medico.getDireccionTrabajoidDireccionTrabajo().getConsultorio()+"\n\n\n"+
        "Puede hacer click en el boton a continuación para mostrarle la lista de sus pacientes");

        _btnBienvenido.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                muestraPacientes();
            }
        });
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
                .setName("Welcome Page") // TODO: Define a title for the content shown.
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
     * Método que se encarga de hacer una llamada al servicio web para obtener la lista de pacientes del médico.
     */
    public void muestraPacientes(){

        final ProgressDialog progressDialog = new ProgressDialog(WelcomeActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Obteniendo pacientes..");
        progressDialog.show();

        RequestParams request = new RequestParams();
        request.add("idMedico", medico.getIdMedico().toString());
        PacienteRestClient.getPacientesForShow("getPacienteForShow/", request, new JsonHttpResponseHandler(){

            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                ObjectMapper mapper = new ObjectMapper();
                ArrayList<ShowPaciente> pacienteList = new ArrayList<ShowPaciente>();
                try{
                    pacienteList = mapper.readValue(response.toString(), new TypeReference<ArrayList<ShowPaciente>>(){});
                }
                catch(Exception e){
                    e.printStackTrace();
                    progressDialog.dismiss();

                }

                progressDialog.dismiss();
                listSuccess(pacienteList);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getBaseContext(), "Error al obtener lista", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    /**
     * Método que se encarga de enviar una lista de pacientes para ser mostrados en la actividad que se encarga de presentar la lista
     * de pacientes del médico.
     * @param pacienteList ArrayList<ShowPaciente> que se envía para ser mostrada en la lista de pacientes.
     */
    public void listSuccess(ArrayList<ShowPaciente> pacienteList){
        Intent i = new Intent(getApplicationContext(), ListaPacientesActivity.class);
        i.putExtra("pacientes", pacienteList);
        i.putExtra("idMedico", medico.getIdMedico());
        startActivity(i);
    }
}
