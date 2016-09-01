package br.com.anymarket.sdk.dto.push;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by fernando.gomes on 26/08/2016.
 * Classe para facilitar a implementação do push
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PushCallbackDTO {

    public static final int MAGIC_HASH = 31;
    @JsonProperty("type")
    private PushType type;

    @JsonProperty("content")
    private PushCallbackContentDTO contentDTO;

    public PushType getType() {
        return type;
    }

    public PushCallbackContentDTO getContentDTO() {
        return contentDTO;
    }

    @Override
    public String toString() {
        return "PushCallbackDTO{" +
            "type=" + type +
            ", contentDTO=" + contentDTO +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        PushCallbackDTO that = (PushCallbackDTO) o;

        if (type != that.type) {
            return false;
        }
        return contentDTO.equals(that.contentDTO);

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = MAGIC_HASH * result + contentDTO.hashCode();
        return result;
    }
}
