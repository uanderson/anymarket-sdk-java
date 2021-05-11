package br.com.anymarket.sdk.callback;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by fernando.gomes on 26/08/2016.
 * Classe para facilitar a implementação do push
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PushCallbackContentDTO {

    public static final int MAGIC_HASH = 31;
    @JsonProperty("oi")
    private String oi;
    @JsonProperty("id")
    private String resourceId;

    public String getOi() {
        return oi;
    }

    public void setOi(String oi) {
        this.oi = oi;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "br.com.anymarket.sdk.callback.PushCallbackContentDTO{" +
            "oi='" + oi + '\'' +
            ", resourceId='" + resourceId + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PushCallbackContentDTO that = (PushCallbackContentDTO) o;

        if (!oi.equals(that.oi)) {
            return false;
        }
        return resourceId.equals(that.resourceId);

    }

    @Override
    public int hashCode() {
        int result = oi.hashCode();
        result = MAGIC_HASH * result + resourceId.hashCode();
        return result;
    }
}
