package br.com.anymarket.sdk.monitor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import static br.com.anymarket.sdk.AnymarketPojo.MAGICAL_HASH_CODE;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by marcio.scharam on 08/03/2016.
 */
public class Monitor {

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

    protected Monitor() {}

    private Monitor(Builder builder) {

        if (builder.id == null && builder.partnerId == null) {
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

    public void concatRetryCallbackPathWithModule(String module, String retryCallbackPath) {
        this.retryCallbackURL = module + retryCallbackPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Monitor monitor = (Monitor) o;

        if (id != null ? !id.equals(monitor.id) : monitor.id != null) {
            return false;
        }
        if (!partnerId.equals(monitor.partnerId)) {
            return false;
        }
        if (!origin.equals(monitor.origin)) {
            return false;
        }
        if (!message.equals(monitor.message)) {
            return false;
        }
        if (!details.equals(monitor.details)) {
            return false;
        }
        if (type != monitor.type) {
            return false;
        }
        if (retryCallbackURL != null ? !retryCallbackURL.equals(monitor.retryCallbackURL) : monitor.retryCallbackURL != null) {
            return false;
        }
        if (!createdAt.equals(monitor.createdAt)) {
            return false;
        }
        return status == monitor.status;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = MAGICAL_HASH_CODE * result + partnerId.hashCode();
        result = MAGICAL_HASH_CODE * result + origin.hashCode();
        result = MAGICAL_HASH_CODE * result + message.hashCode();
        result = MAGICAL_HASH_CODE * result + details.hashCode();
        result = MAGICAL_HASH_CODE * result + type.hashCode();
        result = MAGICAL_HASH_CODE * result + (retryCallbackURL != null ? retryCallbackURL.hashCode() : 0);
        result = MAGICAL_HASH_CODE * result + createdAt.hashCode();
        result = MAGICAL_HASH_CODE * result + status.hashCode();
        return result;
    }

    public static class Builder {
        private Long id;
        private String partnerId;
        private String origin;
        private String message;
        private String details;
        private MonitorType monitorType = MonitorType.ALERT;
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
