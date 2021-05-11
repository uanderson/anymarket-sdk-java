package br.com.anymarket.sdk.stock.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page implements AnymarketPojo {
    private int size;
    private int totalElements;
    private int totalPages;
    private int number;

    private Page() {}

    public Page(Builder builder) {
        this.size = builder.size;
        this.totalElements = builder.totalElements;
        this.totalPages = builder.totalPages;
        this.number = builder.number;
    }

    public static class Builder {
        private int size;
        private int totalElements;
        private int totalPages;
        private int number;

        public Builder withSize(int size) {
            this.size = size;
            return this;
        }

        public Builder withTotalElements(int totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public Builder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Builder withNumber(int number) {
            this.number = number;
            return this;
        }

        public Page build() {
            return new Page(this);
        }

    }

    public static Page.Builder builder() {
        return new Page.Builder();
    }

    public int getSize() {
        return size;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String getPathURI() {
        return "/stocks";
    }

}
