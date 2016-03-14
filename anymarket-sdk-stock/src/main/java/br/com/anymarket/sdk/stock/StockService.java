package br.com.anymarket.sdk.stock;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.stock.dto.Stock;
import br.com.anymarket.sdk.stock.dto.StockCollection;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.body.RequestBodyEntity;

import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by marcio.scharam on 29/01/2016.
 */
public class StockService extends HttpService {

    private String apiEndPoint;

    public StockService(String apiEndPoint) {
        if (isNullOrEmpty(apiEndPoint)) {
            apiEndPoint = SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        }
        this.apiEndPoint = apiEndPoint;
    }

    public Response updateStock(Stock stock, IntegrationHeader... headers) {
        return updateStock(Lists.newArrayList(stock), headers);
    }

    public Response updateStock(List<Stock> stocks, IntegrationHeader... headers) {
        StockCollection stockCollection = new StockCollection();
        stockCollection.addAllStock(stocks);
        return updateStock(stockCollection, headers);
    }

    public Response updateStock(StockCollection stocks, IntegrationHeader... headers) {
        RequestBodyEntity putRequest = put(apiEndPoint + stocks.getPathURI(), stocks.getStocks(), headers);
        return execute(putRequest);
    }
}
