package br.com.anymarket.sdk.stock.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This class represents an array of Stock info to be sent to AnyMarket by API v2
 */

public class StockCollection implements AnymarketPojo {

    List<Stock> stocks = new ArrayList<Stock>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void addAllStock(List<Stock> stocks) {
        checkNotNull(stocks, "Stocks can not be null.");
        Preconditions.checkArgument(!stocks.isEmpty(), "Stocks can not be empty");
        this.stocks.addAll(stocks);
    }

    public List<Stock> getStocks() {
        return ImmutableList.copyOf(stocks);
    }


    @Override
    public String getPathURI() {
        return "/stocks";
    }

}
