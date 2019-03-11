package br.com.anymarket.sdk.stock;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.stock.dto.Stock;
import br.com.anymarket.sdk.stock.dto.StockCollection;
import br.com.anymarket.sdk.stock.dto.StockLocal;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.apache.http.HttpStatus;

import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;

public class StockService extends HttpService {

    private String apiEndPoint;

    public StockService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
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

    public List<StockLocal> getAllStockLocals(IntegrationHeader... headers) {
        final GetRequest getRequest = get(apiEndPoint.concat("/stocks/locals"), headers);
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(new TypeReference<List<StockLocal>>() {
            });
        } else {
            throw new NotFoundException("Stock Locals not found.");
        }
    }
}
