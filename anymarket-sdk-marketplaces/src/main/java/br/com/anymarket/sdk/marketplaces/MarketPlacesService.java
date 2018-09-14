package br.com.anymarket.sdk.marketplaces;

import br.com.anymarket.sdk.MarketPlace;
import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.HttpClientException;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.paging.Page;
import br.com.anymarket.sdk.template.dto.Template;
import br.com.anymarket.sdk.util.SDKUrlEncoder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.GetRequest;
import org.apache.http.HttpStatus;

import java.util.List;

import static java.lang.String.format;

public class MarketPlacesService extends HttpService {

    private static final String MARKETPLACES_URI = "/marketplaces";
    public static final String SEPARATOR = "/";
    private final String apiEndPoint;

    public MarketPlacesService(String apiEndPoint) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public Template getMarketPlaces(IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint + MARKETPLACES_URI + SEPARATOR, headers);
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(MarketPlaces.class);
        }
        throw new NotFoundException(format("Template with id %s not found.", id));
    }

}
