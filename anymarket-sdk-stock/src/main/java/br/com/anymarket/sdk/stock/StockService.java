package br.com.anymarket.sdk.stock;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.http.restdsl.RestResponse;
import br.com.anymarket.sdk.stock.dto.Stock;
import br.com.anymarket.sdk.stock.dto.StockCollection;
import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;

public class StockService extends HttpService {

    private String apiEndPoint;

    public StockService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public RestResponse updateStock(Stock stock, IntegrationHeader... headers) {
        return updateStock(Lists.newArrayList(stock), headers);
    }

    public RestResponse updateStock(List<Stock> stocks, IntegrationHeader... headers) {
        StockCollection stockCollection = new StockCollection();
        stockCollection.addAllStock(stocks);
        return updateStock(stockCollection, headers);
    }

    public RestResponse updateStock(StockCollection stocks, IntegrationHeader... headers) {
        return executeWithBody(stocks.getStocks(),
            put(apiEndPoint + stocks.getPathURI(), headers)
        );
    }
}
