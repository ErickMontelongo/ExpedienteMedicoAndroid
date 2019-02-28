package WebServicesUtils;

/**
 * Created by Erick Montelongo on 10/11/2016.
 */

import com.loopj.android.http.*;
import android.content.Context;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Esta clase funciona para hacer llamadas HTTP a los servicios web útiles para el médico.
 */

public class MedicoRestClient {

    private static final String BASE_URL = "http://192.168.1.67:8084/ExpedienteMedicoTomcat/webresources/MedicoResourse/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    /**
     * Método que ejecuta una operación de tipo POST en el servicio
     * @param context Contexto de la aplicación android
     * @param url URL del servicio a ejecutar
     * @param object Tipo de objeto a ser enviado
     * @param responseHandler   Objeto que se encarga de procesar la respuesta al ejecutar el servicio con el código HTTP resultante.
     */
    public static void post(Context context, String url, String object, AsyncHttpResponseHandler responseHandler){
        StringEntity entity = new StringEntity(object, "UTF-8");
        client.post(context, getAbsoluteUrl(url), entity, "application/json", responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl){
        return BASE_URL + relativeUrl;
    }
}
