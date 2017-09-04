package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by heidi.kussakawa on 14/07/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTransmissionStatusResource {

    @JsonProperty("transmissionStatus")
    private String transmissionStatus;
    @JsonProperty("errorMsg")
    private String errorMsg;

    public OrderTransmissionStatusResource() {
    }

    private OrderTransmissionStatusResource(Builder builder) {
        this.transmissionStatus = builder.transmissionStatus;
        this.errorMsg = builder.errorMsg;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTransmissionStatus() {
        return transmissionStatus;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String toString() {
        return "OrderTransmissionStatusResource{" +
            "transmissionStatus='" + transmissionStatus + '\'' +
            ", errorMsg='" + errorMsg + '\'' +
            '}';
    }

    public static final class Builder {
        private String transmissionStatus;
        private String errorMsg;

        private Builder() {
        }

        public OrderTransmissionStatusResource build() {
            return new OrderTransmissionStatusResource(this);
        }

        public Builder withTransmissionStatus(String transmissionStatus) {
            this.transmissionStatus = transmissionStatus;
            return this;
        }

        public Builder withErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }
    }
}
