package activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import adapters.RVAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;
import dataholders.ShowPaciente;

/**
 * Created by Punkid PC on 12/11/2016.
 */

/**
 * Actividad que se encarga de presentar la lista de pacientes asignados a un médico asi como la interfaz de búsqueda.
 */
public class ListaPacientesActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private List<ShowPaciente> pacientes;
    private RVAdapter adapter;
    private int idMedico;
    @InjectView(R.id.rv) RecyclerView rv;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacientes);
        ButterKnife.inject(this);
        toolbar.setTitle("Lista de pacientes");
        setSupportActionBar(toolbar);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idMedico = (int) extras.get("idMedico");
        }

        initializeData();
        initializeAdapter();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initializeData(){
        Bundle extras = getIntent().getExtras();
        pacientes = new ArrayList<>();
        if(extras != null){
            pacientes = (ArrayList<ShowPaciente>) extras.get("pacientes");
        }
    }

    /**
     * Método de inicialización del adaptador de las Cards
     */
    private void initializeAdapter() {
        adapter = new RVAdapter(pacientes);
        adapter.setIdMedico(idMedico);
        rv.setAdapter(adapter);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ListaPacientes Page") // TODO: Define a title for the content shown.
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
     * Método para la creación de la barra superior y asignar una barra de búsqueda
     * @param menu Objeto de tipo Menu que hace referencia a la interfaz a mostrar
     * @return Verdadero al finalizar la creación
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    /**
     * Método para realizar la búsqueda cuando se presione enter en la barra de búsqueda.
     * @param query Cadena con la cual se realizará la búsqueda
     * @return Verdadero al finalizar la búsqueda
     */
    @Override
    public boolean onQueryTextSubmit(String query) {
        adapter.getFilter().filter(query);
        return true;
    }

    /**
     * Método que se encarga de realizar la búsqueda cuando el médico se encuentre escribiendo su término de búsqueda.
     * @param query Cadena que representa el término de búsqueda
     * @return Verdadero al finalizar la búsqueda.
     */
    @Override
    public boolean onQueryTextChange(String query){
        adapter.getFilter().filter(query);
        return true;
    }

}
