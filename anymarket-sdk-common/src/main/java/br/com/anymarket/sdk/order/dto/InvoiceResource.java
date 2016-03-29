package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Dados da nota vindo do ERP
 */
public class InvoiceResource{

    @JsonProperty("accessKey")
    private String accessKey;

    @JsonProperty("series")
    private String series;

    @JsonProperty("number")
    private String number;

    @JsonProperty("date")
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
}
