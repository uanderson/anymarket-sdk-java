package br.com.anymarket.sdk.freight.dto;

import br.com.anymarket.sdk.MarketPlace;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class FreightResponse {

    @JsonProperty(value = "marketPlace")
    private MarketPlace marketPlace;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("products")
    private List<FreightProduct> products = new ArrayList<FreightProduct>();

    @JsonProperty("quotes")
    private List<FreightQuote> quotes = new ArrayList<FreightQuote>();

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<FreightProduct> getProducts() {
        return products;
    }

    public List<FreightQuote> getQuotes() {
        return quotes;
    }
}
