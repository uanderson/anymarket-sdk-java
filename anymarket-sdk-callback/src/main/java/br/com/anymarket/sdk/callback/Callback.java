package br.com.anymarket.sdk.callback;

import br.com.anymarket.sdk.AnymarketPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * Created by gyowannyqueiroz on 7/19/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Callback implements AnymarketPojo {

    public static final int MAGIC_HASH = 31;
    @JsonProperty("id")
    private Long id;

    @JsonProperty("url")
    private String url;

    public Callback() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getPathURI() {
        return "/callback";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Callback callback = (Callback) o;

        if (id != null ? !id.equals(callback.id) : callback.id != null) {
            return false;
        }
        return url.equals(callback.url);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = MAGIC_HASH * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("url", url)
                .toString();
    }
}
