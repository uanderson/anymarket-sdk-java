package br.com.anymarket.sdk.stock.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static java.util.Objects.isNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockKeepingUnit implements AnymarketPojo {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("partnerId")
    private String partnerId;
    @JsonProperty("title")
    private String title;

    private StockKeepingUnit(StockKeepingUnit.Builder builder) {
        if (isNull(builder.id) && isNull(builder.partnerId) && isNull(builder.title)) {
            throw new IllegalArgumentException("It must be filled the id or partnerId or title");
        }
        this.id = builder.id;
        this.partnerId = builder.partnerId;
        this.title = builder.title;
    }

    public static class Builder {
        private Long id;
        private String partnerId;
        private String title;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withPartnerId(String partnerId) {
            this.partnerId = partnerId;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public StockKeepingUnit build() {
            return new StockKeepingUnit(this);
        }

    }

    public static StockKeepingUnit.Builder builder() {
        return new StockKeepingUnit.Builder();
    }

    public Long getId() {
        return id;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getPathURI() {
        return "/stocks";
    }

    public StockKeepingUnit() {}

}
