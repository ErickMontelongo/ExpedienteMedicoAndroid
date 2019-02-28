package activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

import adapters.MedicamentoRVAdapter;
import butterknife.InjectView;
import dataholders.Medicamento;
import dataholders.Prescripcion;

/**
 * Created by Punkid PC on 17/11/2016.
 */

public class MedicamentosActivity extends Fragment implements SearchView.OnQueryTextListener{


    private List<Prescripcion> prescripciones;
    private MedicamentoRVAdapter adapter;

    RecyclerView rv;


    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_medicamentos_rv, container, false);
        rv = (RecyclerView) rootView.findViewById(R.id.medicamentos_rv);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.setHasFixedSize(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Lista de Medicamentos");
        initializeAdapter();
        return rootView;
    }



    private void initDataset() {
        prescripciones = ((ResumenActivity)getActivity()).getPrescripciones();
    }

    private void initializeAdapter(){
        adapter = new MedicamentoRVAdapter(prescripciones);
        rv.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater){
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView sv = (SearchView) searchItem.getActionView();
        sv.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
       adapter.getFilter().filter(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return true;
    }
}
