package br.com.anymarket.sdk.stock.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link  implements AnymarketPojo {

    public static final String REL_NEXT = "next";

    @JsonProperty("rel")
    private String relative;
    @JsonProperty("href")
    private String url;

    private Link() {}

    public Link(Builder builder) {
        this.relative = builder.relative;
        this.url = builder.url;
    }

    public static class Builder {
        private String relative;
        private String url;

        public Builder withRelative(String relative) {
            this.relative = relative;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Link build() {
            return new Link(this);
        }
    }

    public static Link.Builder builder() {
        return new Link.Builder();
    }

    public String getRelative() {
        return relative;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String getPathURI() {
        return "/stocks";
    }

}
