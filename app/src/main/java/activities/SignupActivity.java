package activities;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;

import WebServicesUtils.MedicoRestClient;
import butterknife.ButterKnife;
import butterknife.InjectView;
import cz.msebera.android.httpclient.Header;
import dataholders.*;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @InjectView(R.id.input_name)
    EditText _nameText;
    @InjectView(R.id.input_apellidoP)
    EditText _apellidoP;
    @InjectView(R.id.input_apellidoM)
    EditText _apellidoM;
    @InjectView(R.id.input_cedula)
    EditText _emailText;
    @InjectView(R.id.input_password)
    EditText _passwordText;
    @InjectView(R.id.input_universidad_nombre)
    EditText _nombreUniversidad;
    @InjectView(R.id.input_universidad_clave)
    EditText _claveUniversidad;
    @InjectView(R.id.input_especialidad_nombre)
    EditText _nombreEspecialidad;
    @InjectView(R.id.input_direccion_nombreEmpresa)
    EditText _nombreEmpresa;
    @InjectView(R.id.input_direccion_consultorio)
    EditText _consultorioEmpresa;
    @InjectView(R.id.input_direccion_estado)
    EditText _estadoEmpresa;
    @InjectView(R.id.input_direccion_municipio)
    EditText _municipioEmpresa;
    @InjectView(R.id.input_direccion_colonia)
    EditText _coloniaEmpresa;
    @InjectView(R.id.input_direccion_calle)
    EditText _calleEmpresa;
    @InjectView(R.id.input_direccion_telefono)
    EditText _telefonoEmpresa;
    @InjectView(R.id.input_direccion_cp)
    EditText _cpEmpresa;
    @InjectView(R.id.btn_signup)
    Button _signupButton;
    @InjectView(R.id.link_login)
    TextView _loginLink;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.inject(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creando cuenta...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String apellidoP = _apellidoP.getText().toString();
        String apellidoM = _apellidoM.getText().toString();
        String nombreUniversidad = _nombreUniversidad.getText().toString();
        String claveUniversidad = _claveUniversidad.getText().toString();
        String nombreEspecialidad = _nombreEspecialidad.getText().toString();
        String nombreEmpresa = _nombreEmpresa.getText().toString();
        String consultorioEmpresa = _consultorioEmpresa.getText().toString();
        String estadoEmpresa = _estadoEmpresa.getText().toString();
        String municipioEmpresa = _municipioEmpresa.getText().toString();
        String coloniaEmpresa = _coloniaEmpresa.getText().toString();
        String calleEmpresa = _calleEmpresa.getText().toString();
        String telefonoEmpresa = _telefonoEmpresa.getText().toString();
        String cpEmpresa = _cpEmpresa.getText().toString();

        // TODO: Implement your own signup logic here.

        Universidad uni = new Universidad();
        Especialidad esp = new Especialidad();
        Direcciontrabajo dir = new Direcciontrabajo();
        Medico medico = new Medico();

        uni.setClave(claveUniversidad);
        uni.setNombre(nombreUniversidad);

        esp.setNombre(nombreEspecialidad);

        dir.setCalle(calleEmpresa);
        dir.setCodigoPostal(cpEmpresa);
        dir.setColonia(coloniaEmpresa);
        dir.setCalle(calleEmpresa);
        dir.setNombreEmpresa(nombreEmpresa);
        dir.setConsultorio(consultorioEmpresa);
        dir.setEstado(estadoEmpresa);
        dir.setMunicipio(municipioEmpresa);
        dir.setNumeroTel(telefonoEmpresa);
        dir.setCodigoPostal(cpEmpresa);

        medico.setNombre(name);
        medico.setApellidoP(apellidoP);
        medico.setApellidoM(apellidoM);
        medico.setIdMedico(Integer.parseInt(email));
        medico.setPassword(password);
        medico.setUniversidadidUniversidad(uni);
        medico.setEspecialidadidEspecialidad(esp);
        medico.setDireccionTrabajoidDireccionTrabajo(dir);

        Gson object = new Gson();
        String mapper = object.toJson(medico);

        MedicoRestClient.post(getApplicationContext(), "registraMedico/", mapper, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                new Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                // On complete call either onSignupSuccess or onSignupFailed
                                // depending on success
                                onSignupSuccess();
                                // onSignupFailed();
                                progressDialog.dismiss();
                            }
                        }, 3000);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                new Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                // On complete call either onSignupSuccess or onSignupFailed
                                // depending on success
                                onSignupFailed();
                                progressDialog.dismiss();
                            }
                        }, 3000);
            }
        });

    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String apellidoP = _apellidoP.getText().toString();
        String apellidoM = _apellidoM.getText().toString();
        String nombreUniversidad = _nombreUniversidad.getText().toString();
        String claveUniversidad = _claveUniversidad.getText().toString();
        String nombreEspecialidad = _nombreEspecialidad.getText().toString();
        String nombreEmpresa = _nombreEmpresa.getText().toString();
        String consultorioEmpresa = _consultorioEmpresa.getText().toString();
        String estadoEmpresa = _estadoEmpresa.getText().toString();
        String municipioEmpresa = _municipioEmpresa.getText().toString();
        String coloniaEmpresa = _coloniaEmpresa.getText().toString();
        String calleEmpresa = _calleEmpresa.getText().toString();
        String telefonoEmpresa = _telefonoEmpresa.getText().toString();
        String cpEmpresa = _cpEmpresa.getText().toString();

        if (name.isEmpty() || name.length() > 25) {
            _nameText.setError("Ingrese su nombre");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (apellidoP.isEmpty()) {
            _apellidoP.setError("Ingrese su apellido paterno");
            valid = false;
        } else {
            _apellidoP.setError(null);
        }

        if (apellidoM.isEmpty()) {
            _apellidoM.setError("Ingrese su apellido materno");
            valid = false;
        } else {
            _apellidoM.setError(null);
        }

        if (email.isEmpty()) {
            _emailText.setError("Ingrese una cedula profesional");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty()) {
            _passwordText.setError("Ingrese una contraseña");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (nombreUniversidad.isEmpty()) {
            _nombreUniversidad.setError("Ingrese el nombre de la universidad");
            valid = false;
        } else {
            _nombreUniversidad.setError(null);
        }

        if (claveUniversidad.isEmpty()) {
            _claveUniversidad.setError("Ingrese la clave de su universidad");
            valid = false;
        } else {
            _claveUniversidad.setError(null);
        }

        if (nombreEspecialidad.isEmpty()) {
            _nombreEspecialidad.setError("Indique su especialidad");
            valid = false;
        } else {
            _nombreEspecialidad.setError(null);
        }

        if (nombreEmpresa.isEmpty()) {
            _nombreEmpresa.setError("Ingrese el nombre de la empresa");
            valid = false;
        } else {
            _nombreEmpresa.setError(null);
        }

        if (consultorioEmpresa.isEmpty()) {
            _consultorioEmpresa.setError("Ingrese el consultorio");
            valid = false;
        } else {
            _consultorioEmpresa.setError(null);
        }

        if (estadoEmpresa.isEmpty()) {
            _estadoEmpresa.setError("Ingrese el estado");
            valid = false;
        } else {
            _estadoEmpresa.setError(null);
        }

        if (municipioEmpresa.isEmpty()) {
            _municipioEmpresa.setError("Indique el municipio");
            valid = false;
        } else {
            _municipioEmpresa.setError(null);
        }

        if (coloniaEmpresa.isEmpty()) {
            _coloniaEmpresa.setError("Ingrese la colonia");
            valid = false;
        } else {
            _coloniaEmpresa.setError(null);
        }

        if (calleEmpresa.isEmpty()) {
            _calleEmpresa.setError("Ingrese la calle");
            valid = false;
        } else {
            _calleEmpresa.setError(null);
        }

        if (telefonoEmpresa.isEmpty()) {
            _telefonoEmpresa.setError("Ingrese el telefono de contacto");
            valid = false;
        } else {
            _telefonoEmpresa.setError(null);
        }

        if (cpEmpresa.isEmpty()) {
            _cpEmpresa.setError("Indique el código postal");
            valid = false;
        } else {
            _cpEmpresa.setError(null);
        }

        return valid;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Signup Page") // TODO: Define a title for the content shown.
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