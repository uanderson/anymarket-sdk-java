package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTransmissionStatusResource {

    @JsonProperty("transmissionStatus")
    private String transmissionStatus;
    @JsonProperty("statusInMarketplace")
    private String statusInMarketplace;
    @JsonProperty("errorMsg")
    private String errorMsg;
    @JsonProperty("orderMessage")
    private OrderMessage orderMessage;

    protected OrderTransmissionStatusResource() {
    }

    private OrderTransmissionStatusResource(Builder builder) {
        this.transmissionStatus = builder.transmissionStatus;
        this.errorMsg = builder.errorMsg;
        this.orderMessage = builder.orderMessage;
        this.statusInMarketplace = builder.statusInMarketplace;
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

    public String getStatusInMarketplace() {
        return statusInMarketplace;
    }

    public OrderMessage getOrderMessage() {
        return orderMessage;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("transmissionStatus", transmissionStatus)
            .add("statusInMarketplace", statusInMarketplace)
            .add("errorMsg", errorMsg)
            .add("orderMessage", orderMessage)
            .toString();
    }

    public static final class Builder {
        private String transmissionStatus;
        private String statusInMarketplace;
        private String errorMsg;
        private OrderMessage orderMessage;

        public static Builder anOrderTransmissionStatusResource() {
            return new Builder();
        }

        public Builder withTransmissionStatus(String transmissionStatus) {
            this.transmissionStatus = transmissionStatus;
            return this;
        }

        public Builder withStatusInMarketplace(String statusInMarketplace) {
            this.statusInMarketplace = statusInMarketplace;
            return this;
        }

        public Builder withErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public Builder withOrderMessage(OrderMessage orderMessage) {
            this.orderMessage = orderMessage;
            return this;
        }

        public OrderTransmissionStatusResource build() {
            return new OrderTransmissionStatusResource(this);
        }
    }
}
