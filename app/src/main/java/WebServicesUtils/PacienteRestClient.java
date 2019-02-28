package WebServicesUtils;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by Erick Montelongo on 12/11/2016.
 */


/**
 * Esta clase sirve para hacer llamadas HTTP a los servicios web útiles para la información del paciente.
 */
public class PacienteRestClient {
    private static final String BASE_URL = "http://192.168.1.67:8084/ExpedienteMedicoTomcat/webresources/Paciente/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    /**
     * Método que ejecuta una operación de tipo GET en el servicio
     * @param url URL del servicio a ejecutar
     * @param params Parametros que acompañan a la petición
     * @param response Objeto que obtiene la respuesta con código HTTP del resultado y su contenido.
     */
    public static void getPacientesForShow(String url, RequestParams params, AsyncHttpResponseHandler response){
        client.get(getAbsoluteUrl(url), params, response);
    }




    private static String getAbsoluteUrl(String relativeUrl){
        return BASE_URL + relativeUrl;
    }
}
