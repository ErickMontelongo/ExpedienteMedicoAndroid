package activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

import adapters.EstudioRVAdapter;
import adapters.SintomaRVAdapter;
import dataholders.Estudiosmedicos;

/**
 * Created by Punkid PC on 17/11/2016.
 */

/**
 * Actividad que se encarga de presentar en pantalla la lista de estudios de laboratorio que tiene un paciente.
 */
public class EstudiosActivity extends Fragment {

    private List<Estudiosmedicos> estudios;
    RecyclerView rv;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_estudio_rv, container, false);
        rv = (RecyclerView) rootView.findViewById(R.id.estudio_rv);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.setHasFixedSize(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Lista de Estudios de laboratorio");
        initDataset();
        initializeAdapter();
        return rootView;
    }


    /**
     * Método que se encarga de obtener la lista de estudios que tiene un paciente.
     */
    private void initDataset() {
        estudios = ((ResumenActivity)getActivity()).getEstudios();
    }

    /**
     * Inicializa la instancia de adaptador para poder mostrar las Cards.
     */
    private void initializeAdapter(){
        EstudioRVAdapter adapter = new EstudioRVAdapter(estudios);
        rv.setAdapter(adapter);
    }

}
