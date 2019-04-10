package br.com.anymarket.sdk.stock.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents Stock Local info to be sent to AnyMarket by API v2
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockLocal implements AnymarketPojo {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("virtual")
    private boolean virtual;
    @JsonProperty("distributor")
    private String distributor;
    @JsonProperty("defaultLocal")
    private boolean defaultLocal;
    @JsonProperty("zipCode")
    private String zipCode;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public String getDistributor() {
        return distributor;
    }

    public boolean isDefaultLocal() {
        return defaultLocal;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String getPathURI() {
        return "/stocks/locals";
    }

}
