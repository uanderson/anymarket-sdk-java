package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractAddressResource {
    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("stateNameNormalized")
    private String stateNameNormalized;

    @JsonProperty("country")
    private String country;

    @JsonProperty("countryAcronymNormalized")
    private String countryAcronymNormalized;

    @JsonProperty("countryNameNormalized")
    private String countryNameNormalized;

    @JsonProperty("number")
    private String number;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("street")
    private String street;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("zipCode")
    private String zipCode;

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

    public String getStateNameNormalized() {
        return stateNameNormalized;
    }

    public void setStateNameNormalized(String stateNameNormalized) {
        this.stateNameNormalized = stateNameNormalized;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
