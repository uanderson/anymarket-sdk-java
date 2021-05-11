package br.com.anymarket.sdk.stock.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static java.util.Objects.isNull;

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

    public StockLocal() {}

    private StockLocal(StockLocal.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.virtual = builder.virtual;
        this.distributor = builder.distributor;
        this.defaultLocal = builder.defaultLocal;
        this.zipCode = builder.zipCode;
    }

    public static class Builder {
        private Long id;
        private String name;
        private boolean virtual;
        private String distributor;
        private boolean defaultLocal;
        private String zipCode;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        public Builder withVirtual(boolean virtual) {
            this.virtual = virtual;
            return this;
        }
        public Builder withDistributor(String distributor) {
            this.distributor = distributor;
            return this;
        }
        public Builder withDefaultLocal(boolean defaultLocal) {
            this.defaultLocal = defaultLocal;
            return this;
        }
        public Builder withZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public StockLocal build() {
            return new StockLocal(this);
        }
    }

    public static StockLocal.Builder builder() {
        return new StockLocal.Builder();
    }

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
