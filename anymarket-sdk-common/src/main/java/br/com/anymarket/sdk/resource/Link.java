package br.com.anymarket.sdk.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class Link {

    @JsonProperty("href")
    private String href;

    @JsonProperty("rel")
    private String rel;

    public String getHref() {
        return href;
    }

    public String getRel() {
        return rel;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(href, rel);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other instanceof Link) {
            Link that = (Link) other;
            return Objects.equal(href, that.href)
                && Objects.equal(rel, that.rel);
        }

        return false;
    }
}
