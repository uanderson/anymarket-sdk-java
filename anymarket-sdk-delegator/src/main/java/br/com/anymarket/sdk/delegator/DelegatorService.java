package br.com.anymarket.sdk.delegator;

import br.com.anymarket.sdk.MarketPlace;
import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import com.google.common.base.Strings;
import com.mashape.unirest.request.body.RequestBodyEntity;

/**
 * Created by marcio.scharam on 08/06/2016.
 */
public class DelegatorService extends HttpService {

    private static final String DELEGATES_URI = "/delegates";
    private final String apiEndPoint;

    public DelegatorService(String apiEndPoint) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public void addToForceSyncMarkupForMarketplace(MarketPlace marketPlace, IntegrationHeader... headers) {
        RequestBodyEntity put = put(apiEndPoint.concat(DELEGATES_URI).concat("/forceSyncMarkup/")
            .concat(marketPlace.toString()), null, headers);
        execute(put);
    }
}
