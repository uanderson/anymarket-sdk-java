package br.com.anymarket.sdk.monitor;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.monitor.dto.Monitor;

import static br.com.anymarket.sdk.http.headers.AnymarketHeaderUtils.addModuleOriginHeader;
import static br.com.anymarket.sdk.http.restdsl.AnyMarketRestDSL.post;
import static br.com.anymarket.sdk.http.restdsl.AnyMarketRestDSL.put;
import static com.google.common.base.Strings.isNullOrEmpty;

public class MonitorService {

    private static final String CONCLUDE = "/conclude";
    private String apiEndPoint;
    private static final String MONITONING_URI = "/monitorings";
    private String moduleOrigin;

    public MonitorService(String apiEndPoint) {
        if (isNullOrEmpty(apiEndPoint)) {
            apiEndPoint = SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        }
        this.apiEndPoint = apiEndPoint;
    }

    public MonitorService(String apiEndPoint, String origin) {
        if (isNullOrEmpty(apiEndPoint)) {
            apiEndPoint = SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        }
        this.apiEndPoint = apiEndPoint;
        this.moduleOrigin = origin;
    }

    public Response insert(Monitor monitor, IntegrationHeader... headers) {
        return post(apiEndPoint + MONITONING_URI)
                .headers(addModuleOriginHeader(headers, this.moduleOrigin))
                .body(monitor)
                .getResponse();
    }

    public Response conclude(Monitor monitor, IntegrationHeader... headers) {
        return post(apiEndPoint + MONITONING_URI + CONCLUDE)
                .headers(addModuleOriginHeader(headers, this.moduleOrigin))
                .body(monitor)
                .getResponse();
    }

    public Response update(Monitor monitor, IntegrationHeader... headers) {
        return put(apiEndPoint.concat("{pathUri}/{id}"))
                .headers(addModuleOriginHeader(headers, this.moduleOrigin))
                .routeParam("pathUri", MONITONING_URI)
                .routeParam("id", monitor.getId().toString())
                .body(monitor)
                .getResponse();
    }
}
