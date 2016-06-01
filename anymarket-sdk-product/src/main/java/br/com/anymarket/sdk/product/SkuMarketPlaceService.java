package br.com.anymarket.sdk.product;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.HttpService;

import static com.google.common.base.Strings.isNullOrEmpty;

public class SkuMarketPlaceService extends HttpService {

    private static final String SKU_URI = "/skus/%s/marketplaces/";
    private final String apiEndPoint;

    public SkuMarketPlaceService(final String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }
}
