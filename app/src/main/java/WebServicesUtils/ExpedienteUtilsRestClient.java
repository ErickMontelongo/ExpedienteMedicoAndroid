package WebServicesUtils;

import android.content.Context;

import com.loopj.android.http.*;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by Erick Montelongo on 11/11/2016.
 */

/**
 * Esta clase funciona para hacer llamadas html a un servicio web REST del expediente médico.
 */

public class ExpedienteUtilsRestClient {

    /**
     * Se refiere a la ruta base del servicio a ser ejecutado.
     */
    private static final String BASE_URL="http://192.168.1.67:8084/ExpedienteMedicoTomcat/webresources/ExpedienteUtils/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    /**
     * Método que ejecuta una operación de tipo GET en el servicio
     * @param url URL del servicio a ejecutar
     * @param params Parametros que acompañan a la petición
     * @param response Objeto que obtiene la respuesta con código HTTP del resultado y su contenido.
     */
    public static void get(String url, RequestParams params, AsyncHttpResponseHandler response){
        client.get(getAbsoluteUrl(url), params, response);
    }

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
