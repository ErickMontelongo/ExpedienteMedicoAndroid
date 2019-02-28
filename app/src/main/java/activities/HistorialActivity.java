package activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import activities.historialActivities.AlergiasActivity;
import activities.historialActivities.AntecedentesActivity;
import activities.historialActivities.CirugiaActivity;
import activities.historialActivities.EnfermedadesActivity;
import activities.historialActivities.HospitalizacionActivity;
import activities.historialActivities.InformacionActivity;
import activities.historialActivities.ToxicomaniasActivity;
import activities.historialActivities.VacunasActivity;
import dataholders.Alergias;
import dataholders.Cirugias;
import dataholders.Enfermedades;
import dataholders.Historiaclinica;
import dataholders.Antecedentes;
import dataholders.Hospitalizacion;
import dataholders.Toxicomanias;
import dataholders.Vacunas;

/**
 * Created by Punkid PC on 17/11/2016.
 */

/**
 * Clase que se encarga de mostrar el menú principal de navegación en los elementos de la historia clínica.
 */
public class HistorialActivity extends Fragment {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private Historiaclinica historiaClinica;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        historiaClinica = ((ResumenActivity)getActivity()).getHistoriaClinica();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.activity_historial, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Historial Clínico");
        rootView = setListeners(rootView);

        return rootView;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Historial Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }



    private View setListeners(View rootView){

        Button _buttonInfo = (Button) rootView.findViewById(R.id.hitorial_button_info);
        Button _buttonAntecedentes  = (Button) rootView.findViewById(R.id.hitorial_button_antecedente);
        Button _buttonAlergias = (Button) rootView.findViewById(R.id.hitorial_button_alergia);
        Button _buttonEnfermedades = (Button) rootView.findViewById(R.id.hitorial_button_enfermedad);
        Button _buttonToxicomanias = (Button) rootView.findViewById(R.id.hitorial_button_toxicomanias);
        Button _buttonVacunas = (Button) rootView.findViewById(R.id.hitorial_button_vacunas);
        Button _buttonHospitalizacion = (Button) rootView.findViewById(R.id.hitorial_button_hospitalizacion);
        Button _buttonCirugias = (Button) rootView.findViewById(R.id.hitorial_button_cirugias);

        _buttonInfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), InformacionActivity.class);
                i.putExtra("informacion", historiaClinica.getInformacionPersonalidInformacionPersonal());
                v.getContext().startActivity(i);
            }
        });

        _buttonAntecedentes.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AntecedentesActivity.class);
                i.putExtra("antecedentes", (ArrayList<Antecedentes>) historiaClinica.getAntecedentesCollection());
                v.getContext().startActivity(i);
            }
        });

        _buttonAlergias.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AlergiasActivity.class);
                i.putExtra("alergias", (ArrayList<Alergias>) historiaClinica.getAlergiasCollection());
                v.getContext().startActivity(i);
            }
        });

        _buttonEnfermedades.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), EnfermedadesActivity.class);
                i.putExtra("enfermedades", (ArrayList<Enfermedades>) historiaClinica.getEnfermedadesCollection());
                v.getContext().startActivity(i);
            }
        });

        _buttonToxicomanias.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ToxicomaniasActivity.class);
                i.putExtra("toxicomanias", (ArrayList<Toxicomanias>) historiaClinica.getToxicomaniasCollection());
                v.getContext().startActivity(i);

            }
        });

        _buttonVacunas.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), VacunasActivity.class);
                i.putExtra("vacunas", (ArrayList<Vacunas>) historiaClinica.getVacunasCollection());
                v.getContext().startActivity(i);
            }
        });

        _buttonHospitalizacion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), HospitalizacionActivity.class);
                i.putExtra("hospitalizaciones", (ArrayList<Hospitalizacion>)historiaClinica.getHospitalizacionCollection());
                v.getContext().startActivity(i);
            }
        });

        _buttonCirugias.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), CirugiaActivity.class);
                i.putExtra("cirugias", (ArrayList<Cirugias>)historiaClinica.getCirugiasCollection());
                v.getContext().startActivity(i);
            }
        });

        return rootView;
    }


}
