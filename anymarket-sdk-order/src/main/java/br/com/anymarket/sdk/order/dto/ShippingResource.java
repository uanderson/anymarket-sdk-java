package br.com.anymarket.sdk.order.dto;

import br.com.anymarket.sdk.serializer.SDKDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingResource {

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("countryAcronymNormalized")
    private String countryAcronymNormalized;

    @JsonProperty("countryNameNormalized")
    private String countryNameNormalized;

    @JsonProperty("address")
    private String address;

    @JsonProperty("street")
    private String street;

    @JsonProperty("number")
    private String number;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("promisedShippingTime")
    @JsonSerialize(using = SDKDateSerializer.class)
    private Date promisedShippingTime;

    @JsonProperty("receiverName")
    private String receiverName;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAcronymNormalized() {
        return countryAcronymNormalized;
    }

    public void setCountryAcronymNormalized(String countryAcronymNormalized) {
        this.countryAcronymNormalized = countryAcronymNormalized;
    }

    public String getCountryNameNormalized() {
        return countryNameNormalized;
    }

    public void setCountryNameNormalized(String countryNameNormalized) {
        this.countryNameNormalized = countryNameNormalized;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Date getPromisedShippingTime() {
        return promisedShippingTime;
    }

    public void setPromisedShippingTime(Date promisedShippingTime) {
        this.promisedShippingTime = promisedShippingTime;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}
