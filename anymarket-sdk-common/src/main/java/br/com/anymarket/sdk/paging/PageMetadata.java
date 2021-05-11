package br.com.anymarket.sdk.paging;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageMetadata {

    @JsonProperty("size")
    private Long size;

    @JsonProperty("totalElements")
    private Long totalElements;

    @JsonProperty("totalPages")
    private Long totalPages;

    @JsonProperty("number")
    private Long number;

    public Long getSize() {
        return size;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public Long getNumber() {
        return number;
    }
}
