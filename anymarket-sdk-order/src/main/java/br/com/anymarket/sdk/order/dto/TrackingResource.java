package br.com.anymarket.sdk.order.dto;

import br.com.anymarket.sdk.serializer.SDKDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingResource {

    @JsonProperty("url")
    private String url;

    @JsonProperty("number")
    private String number;

    @JsonProperty("carrier")
    private String carrier;

    @JsonProperty("date")
    @JsonSerialize(using = SDKDateSerializer.class)
    private Date date;

    @JsonProperty("estimateDate")
    @JsonSerialize(using = SDKDateSerializer.class)
    private Date estimateDate;

    @JsonProperty("shippedDate")
    @JsonSerialize(using = SDKDateSerializer.class)
    private Date shippedDate;

    @JsonProperty("deliveredDate")
    @JsonSerialize(using = SDKDateSerializer.class)
    private Date deliveredDate;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getEstimateDate() {
        return estimateDate;
    }

    public void setEstimateDate(Date estimateDate) {
        this.estimateDate = estimateDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("url", url)
            .add("number", number)
            .add("carrier", carrier)
            .add("date", date)
            .add("estimateDate", estimateDate)
            .add("shippedDate", shippedDate)
            .add("deliveredDate", deliveredDate)
            .toString();
    }
}

