package br.com.anymarket.sdk.monitor;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.monitor.dto.Monitor;

import static br.com.anymarket.sdk.http.restdsl.AnyMarketRestDSL.post;
import static br.com.anymarket.sdk.http.restdsl.AnyMarketRestDSL.put;
import static com.google.common.base.Strings.isNullOrEmpty;

public class MonitorService {

    private static final String CONCLUDE = "/conclude";
    private String apiEndPoint;
    private static final String MONITONING_URI = "/monitorings";

    public MonitorService(String apiEndPoint) {
        if (isNullOrEmpty(apiEndPoint)) {
            apiEndPoint = SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        }
        this.apiEndPoint = apiEndPoint;
    }

    public Response insert(Monitor monitor, IntegrationHeader... headers) {
        return post(apiEndPoint + MONITONING_URI)
                .headers(headers)
                .body(monitor)
                .getResponse();
    }

    public Response conclude(Monitor monitor, IntegrationHeader... headers) {
        return post(apiEndPoint + MONITONING_URI + CONCLUDE)
                .headers(headers)
                .body(monitor)
                .getResponse();
    }

    public Response update(Monitor monitor, IntegrationHeader... headers) {
        return put(apiEndPoint.concat("{pathUri}/{id}"))
                .headers(headers)
                .routeParam("pathUri", MONITONING_URI)
                .routeParam("id", monitor.getId().toString())
                .body(monitor)
                .getResponse();
    }
}
