package activities;

import android.app.Activity;
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

import adapters.SintomaRVAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;
import dataholders.Paciente;
import dataholders.Sintoma;

/**
 * Created by Punkid PC on 17/11/2016.
 */

/**
 * Actividad que se encarga de presentar la lista de síntomas de un paciente.
 */
public class SintomaActivity extends Fragment {

    private List<Sintoma> sintomas;

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
        View rootView = inflater.inflate(R.layout.activity_sintoma_rv, container, false);
        rv = (RecyclerView) rootView.findViewById(R.id.sintoma_rv);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.setHasFixedSize(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Lista de Síntomas");
        initDataset();
        initializeAdapter();
        return rootView;
    }



    private void initDataset() {
        sintomas = ((ResumenActivity)getActivity()).getSintomas();
    }

    private void initializeAdapter(){
        SintomaRVAdapter adapter = new SintomaRVAdapter(sintomas);
        rv.setAdapter(adapter);
    }

}
