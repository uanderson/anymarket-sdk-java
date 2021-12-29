package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

import static com.google.common.base.Strings.isNullOrEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderMessage implements Serializable {

    private String message;
    private String key;
    private Map<String, Object> parameters = Maps.newHashMap();

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setParameters(final Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public boolean isHandledMessage() {
        return !isNullOrEmpty(this.key);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("message", message)
            .add("key", key)
            .add("parameters", parameters)
            .toString();
    }
}
