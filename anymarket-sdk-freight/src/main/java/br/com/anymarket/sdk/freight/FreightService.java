package br.com.anymarket.sdk.freight;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.freight.dto.FreightRequest;
import br.com.anymarket.sdk.freight.dto.FreightResponse;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.apache.http.HttpStatus;

import static br.com.anymarket.sdk.http.headers.AnymarketHeaderUtils.addModuleOriginHeader;
import static com.google.common.base.Strings.isNullOrEmpty;

public class FreightService extends HttpService {

    private static final String FREIGHT_URI = "/freight";
    private final String apiEndPoint;
    private String moduleOrigin;

    public FreightService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public FreightService(String apiEndPoint, String origin) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        this.moduleOrigin = origin;
    }

    public FreightResponse getQuotes(FreightRequest request, IntegrationHeader... headers) {
        RequestBodyEntity postRequest = post(apiEndPoint.concat(FREIGHT_URI).concat("/quotes"), request, addModuleOriginHeader(headers, this.moduleOrigin));
        Response response = execute(postRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(FreightResponse.class);
        }
        throw new RuntimeException("Invalid invocation");
    }

}