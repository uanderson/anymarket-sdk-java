package br.com.anymarket.sdk.order.dto;

import br.com.anymarket.sdk.serializer.SDKDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnymarketOrderAddress {

    @JsonProperty("country")
    private String country;

    @JsonProperty("state")
    private String state;

    @JsonProperty("stateAcronymNormalized")
    private String stateAcronymNormalized;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("address")
    private String address;

    @JsonProperty("street")
    private String street;

    @JsonProperty("number")
    private String number;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("receiverName")
    private String receiverName;

    @JsonProperty("promisedShippingTime")
    @JsonSerialize(using = SDKDateSerializer.class)
    private Date promisedShippingTime;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public String getStateAcronymNormalized() {
        return stateAcronymNormalized;
    }

    public void setStateAcronymNormalized(String stateAcronymNormalized) {
        this.stateAcronymNormalized = stateAcronymNormalized;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getPromisedShippingTime() {
        return promisedShippingTime;
    }

    public void setPromisedShippingTime(Date promisedShippingTime) {
        this.promisedShippingTime = promisedShippingTime;
    }
}
