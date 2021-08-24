package br.com.anymarket.sdk.stock;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.stock.dto.Stock;
import br.com.anymarket.sdk.stock.dto.StockCollection;
import br.com.anymarket.sdk.stock.dto.StockLocal;
import br.com.anymarket.sdk.stock.dto.StockResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;

import static br.com.anymarket.sdk.http.headers.AnymarketHeaderUtils.addModuleOriginHeader;
import static com.google.common.base.Strings.isNullOrEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class StockService extends HttpService {

    private String apiEndPoint;
    private String moduleOrigin;

    public StockService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public StockService(String apiEndPoint, String origin) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        this.moduleOrigin = origin;
    }

    public Response insertStock(Stock stock, IntegrationHeader... headers) {
        return insertStock(Lists.newArrayList(stock), headers);
    }

    public Response insertStock(List<Stock> stocks, IntegrationHeader... headers) {
        StockCollection stockCollection = new StockCollection();
        stockCollection.addAllStock(stocks);
        return insertStock(stockCollection, headers);
    }

    public Response insertStock(StockCollection stocks, IntegrationHeader... headers) {
        RequestBodyEntity putRequest = post(apiEndPoint + stocks.getPathURI(), stocks.getStocks(), addModuleOriginHeader(headers, this.moduleOrigin));
        return execute(putRequest);
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
        RequestBodyEntity putRequest = put(apiEndPoint + stocks.getPathURI(), stocks.getStocks(), addModuleOriginHeader(headers, this.moduleOrigin));
        return execute(putRequest);
    }

    public StockResult getStock(String idSku, String idStockLocal, String sku, long offset,
                              long limit, String sort, String sortDirection, IntegrationHeader... headers) {

        Map<String, Object> params = Maps.newHashMap();
        if (!isBlank(idSku)) {
            params.put("idSku", idSku);
        }
        if (!isBlank(idStockLocal)) {
            params.put("idStockLocal", idStockLocal);
        }
        if (!isBlank(sku)) {
            params.put("sku", sku);
        }
        if (offset != 0) {
            params.put("offset", offset);
        }
        if (limit != 0) {
            params.put("limit", limit);
        }
        if (!isBlank(sort)) {
            params.put("sort", sort);
        }
        if (!isBlank(sortDirection)) {
            params.put("sortDirection", sortDirection);
        }

        HttpRequest getRequest = get(apiEndPoint.concat("/stocks"), addModuleOriginHeader(headers, this.moduleOrigin)).queryString(params);
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(new TypeReference<StockResult>() {});
        }
        throw new NotFoundException("Stock not found.");

    }

    public List<StockLocal> getAllStockLocals(IntegrationHeader... headers) {
        final GetRequest getRequest = get(apiEndPoint.concat("/stocks/locals"), addModuleOriginHeader(headers, this.moduleOrigin));
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(new TypeReference<List<StockLocal>>() {
            });
        } else {
            throw new NotFoundException("Stock Locals not found.");
        }
    }

}
