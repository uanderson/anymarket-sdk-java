package br.com.anymarket.sdk.monitor.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.isNull;

/**
 * Created by marcio.scharam on 08/03/2016.
 */
public class Monitor implements AnymarketPojo {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("partnerId")
    private String partnerId;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("message")
    private String message;
    @JsonProperty("details")
    private String details;
    @JsonProperty("type")
    private MonitorType type;
    @JsonProperty("retryCallbackURL")
    private String retryCallbackURL;
    @JsonProperty("createdAt")
    private Date createdAt;
    @JsonProperty("status")
    private MonitorStatus status;

    private Monitor(Builder builder) {

        if (isNull(builder.id) && isNull(builder.partnerId)) {
            throw new IllegalArgumentException(
                "It must be filled the id or partnerId");
        }
        checkNotNull(builder.origin, "Origing must be filled");
        checkNotNull(builder.message, "Message must be filled");
        checkNotNull(builder.details, "Details must be filled");
        checkNotNull(builder.monitorType, "MonitoringType must be filled");
        checkNotNull(builder.createdAt, "CreatedAt must be filled");
        checkNotNull(builder.monitorStatus, "MonitorStatus must be filled");

        //TODO add log to warn user that callbackUrl is not filled.

        this.id = builder.id;
        this.partnerId = builder.partnerId;
        this.origin = builder.origin;
        this.message = builder.message;
        this.details = builder.details;
        this.type = builder.monitorType;
        this.retryCallbackURL = builder.retryCallbackURL;
        this.createdAt = builder.createdAt;
        this.status = builder.monitorStatus;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }


    public String getPartnerId() {
        return partnerId;
    }


    public String getOrigin() {
        return origin;
    }


    public String getMessage() {
        return message;
    }


    public String getDetails() {
        return details;
    }


    public Date getCreatedAt() {
        return createdAt;
    }


    public MonitorType getType() {
        return type;
    }


    public String getRetryCallbackURL() {
        return retryCallbackURL;
    }

    public MonitorStatus getStatus() {
        return status;
    }

    @Override
    public String getPathURI() {
        return "/monitorings";
    }

    public static class Builder {
        private Long id;
        private String partnerId;
        private String origin;
        private String message;
        private String details;
        private MonitorType monitorType = MonitorType.ERROR;
        private String retryCallbackURL;
        private Date createdAt = new Date();
        private MonitorStatus monitorStatus = MonitorStatus.PENDING;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withPartnerId(String partnerId) {
            this.partnerId = partnerId;
            return this;
        }

        public Builder withOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withDetails(String details) {
            this.details = details;
            return this;
        }

        public Builder withMonitoringType(MonitorType monitorType) {
            this.monitorType = monitorType;
            return this;
        }

        public Builder withRetryCallbackURL(String retryCallbackURL) {
            this.retryCallbackURL = retryCallbackURL;
            return this;
        }

        public Builder withCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder withMonitoringStatus(MonitorStatus monitorStatus) {
            this.monitorStatus = monitorStatus;
            return this;
        }

        public Monitor build() {
            return new Monitor(this);
        }

    }
}
