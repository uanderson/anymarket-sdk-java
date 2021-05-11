package br.com.anymarket.sdk.stock.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockResult implements AnymarketPojo {

    private List<Link> links;
    private List<StockItem> content;
    private Page page;

    private StockResult(){}

    public StockResult(Builder builder) {
        this.links = builder.links;
        this.content = builder.content;
        this.page = builder.page;
    }

    public static class Builder {
        private List<Link> links;
        private List<StockItem> content;
        private Page page;

        public Builder withLinks(List<Link> links) {
            this.links = links;
            return this;
        }

        public Builder withContent(List<StockItem> content) {
            this.content = content;
            return this;
        }

        public Builder withPage(Page page) {
            this.page = page;
            return this;
        }

        public StockResult build() {
            return new StockResult(this);
        }
    }

    public static StockResult.Builder builder() {
        return new StockResult.Builder();
    }

    public List<Link> getLinks() {
        return links;
    }

    public List<StockItem> getContent() {
        return content;
    }

    public Page getPage() {
        return page;
    }

    @Override
    public String getPathURI() {
        return "/stocks";
    }
}
