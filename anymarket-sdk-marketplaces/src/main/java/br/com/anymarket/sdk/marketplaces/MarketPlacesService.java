package br.com.anymarket.sdk.marketplaces;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.marketplaces.dto.MarketPlacesDTO;
import com.google.common.base.Strings;
import com.mashape.unirest.request.GetRequest;
import org.apache.http.HttpStatus;

import static br.com.anymarket.sdk.http.headers.AnymarketHeaderUtils.addModuleOriginHeader;

public class MarketPlacesService extends HttpService {

    private static final String MARKETPLACES_URI = "/marketplaces";
    private static final String STATUS = "?status=";
    private final String apiEndPoint;
    private String moduleOrigin;

    public MarketPlacesService(String apiEndPoint) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public MarketPlacesService(String apiEndPoint, String origin) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        this.moduleOrigin = origin;
    }

    public MarketPlacesDTO getMarketPlaces(String status, IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint + MARKETPLACES_URI + STATUS + status, addModuleOriginHeader(headers, moduleOrigin));
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(MarketPlacesDTO.class);
        }
        throw new NotFoundException("Marketplaces not found.");
    }

}
