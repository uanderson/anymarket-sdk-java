package br.com.anymarket.sdk.order.dto;

import br.com.anymarket.sdk.serializer.SDKDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;

import java.util.Date;

/**
 * Dados da nota vindo do ERP
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceResource {

    @JsonProperty("accessKey")
    private String accessKey;

    @JsonProperty("series")
    private String series;

    @JsonProperty("number")
    private String number;

    @JsonProperty("date")
    @JsonSerialize(using = SDKDateSerializer.class)
    private Date date;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("accessKey", accessKey)
            .add("series", series)
            .add("number", number)
            .add("date", date)
            .toString();
    }
}
