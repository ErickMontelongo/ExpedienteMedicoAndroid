package activities;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import dataholders.Estudiosmedicos;
import dataholders.Historiaclinica;
import dataholders.Paciente;
import dataholders.Permisos;
import dataholders.Prescripcion;
import dataholders.Sintoma;


/**
 * Created by Punkid PC on 17/11/2016.
 */

/**
 * Actividad que se encarga de presentar la vista principal en el resumen de expediente del paciente.
 */
public class ResumenActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.drawer_layout) DrawerLayout mDrawer;

    @InjectView(R.id.nvView) NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    private Permisos permisos;
    private Paciente paciente;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        ButterKnife.inject(this);
        toolbar.setTitle("Resumen del paciente");
        setSupportActionBar(toolbar);

        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);
        //setupDrawerContent(nvDrawer);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            permisos = (Permisos) extras.get("permisos");
            paciente = (Paciente) extras.get("paciente");
        }

        Menu menu = nvDrawer.getMenu();
        MenuItem sintomas = menu.getItem(0);
        MenuItem estudios = menu.getItem(1);
        MenuItem medicamentos = menu.getItem(2);
        MenuItem historial = menu.getItem(3);
        sintomas.setEnabled(permisos.isSintomas());
        sintomas.setVisible(permisos.isSintomas());
        estudios.setEnabled(permisos.isEstudios());
        estudios.setVisible(permisos.isEstudios());
        medicamentos.setEnabled(permisos.isMedicamentos());
        medicamentos.setEnabled(permisos.isMedicamentos());
        historial.setEnabled(permisos.isHistorial());
        historial.setVisible(permisos.isHistorial());
        setupDrawerContent(nvDrawer);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flContent, new DefaultFragment());
        ft.commit();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Resumen Page") // TODO: Define a title for the content shown.
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(drawerToggle.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId()){
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Método para asignar el contenido de un menú de navegación
     * @param navigationView Objeto para visualizar un menu de navegación
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    /**
     * Método que se encarga de definir que elemento del menú lateral de navegación fué presionado.
     * Así como presentar en el fragmento de pantalla la información relacionada al elemento presionado.
     * @param menuItem Instancia del menú que fúe presionada.
     */
    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_sintomas:
                fragmentClass = SintomaActivity.class;
                break;
            case R.id.nav_estudios:
                fragmentClass = EstudiosActivity.class;
                break;
            case R.id.nav_medicamentos:
                fragmentClass = MedicamentosActivity.class;
                break;
            case R.id.nav_historial:
                fragmentClass = HistorialActivity.class;
                break;
            default:
                fragmentClass = DefaultFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Método que se encarga en obtener la lista de síntomas del paciente
     * @return ArrayList de tipo Sintoma
     */
    public ArrayList<Sintoma> getSintomas(){
        return (ArrayList<Sintoma>)paciente.getSintomaCollection();
    }

    /**
     * Método que se encarga en obtener la lista de estudios de laboratorio del paciente.
     * @return ArrayList de tipo Estudiosmedicos
     */
    public ArrayList<Estudiosmedicos> getEstudios(){
        return (ArrayList<Estudiosmedicos>) paciente.getEstudiosmedicosCollection();
    }

    /**
     * Método que se encarga de obtener la lista de prescripciones de un paciente
     * @return ArrayList de tipo Prescripcion
     */
    public ArrayList<Prescripcion> getPrescripciones(){
        return (ArrayList<Prescripcion>) paciente.getPrescripcionCollection();
    }

    /**
     * Método que se encarga de obtener la historia clínica del paciente
     * @return ArrayList de tipo Historiaclinica
     */
    public Historiaclinica getHistoriaClinica(){
        return paciente.getHistoriaClinicaidHistoriaClinica();
    }


}
