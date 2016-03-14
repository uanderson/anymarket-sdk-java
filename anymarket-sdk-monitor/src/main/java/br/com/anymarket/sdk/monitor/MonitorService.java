package br.com.anymarket.sdk.monitor;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.monitor.dto.Monitor;
import com.mashape.unirest.request.body.RequestBodyEntity;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by marcio.scharam on 08/03/2016.
 */
public class MonitorService extends HttpService {

    private String apiEndPoint;

    public MonitorService(String apiEndPoint) {
        if (isNullOrEmpty(apiEndPoint)) {
            apiEndPoint = SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        }
        this.apiEndPoint = apiEndPoint;
    }

    public Response insert(Monitor monitor, IntegrationHeader... headers) {
        RequestBodyEntity postRequest = post(apiEndPoint + monitor.getPathURI(), monitor, headers);
        return execute(postRequest);
    }

    public Response update(Monitor monitor, IntegrationHeader... headers) {
        RequestBodyEntity putRequest = put(apiEndPoint + monitor.getPathURI() + "/" + monitor.getId(), monitor, headers);
        return execute(putRequest);
    }
}
