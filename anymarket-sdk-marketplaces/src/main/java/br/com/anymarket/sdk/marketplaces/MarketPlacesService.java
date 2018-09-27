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

public class MarketPlacesService extends HttpService {

    private static final String MARKETPLACES_URI = "/marketplaces";
    private static final String STATUS = "?status=";
    private final String apiEndPoint;

    public MarketPlacesService(String apiEndPoint) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public MarketPlacesDTO getMarketPlaces(String status, IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint + MARKETPLACES_URI + STATUS + status, headers);
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(MarketPlacesDTO.class);
        }
        throw new NotFoundException("Marketplaces not found.");
    }

}
