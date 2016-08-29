package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuyerAddressResource {

    @JsonProperty("country")
    private String country;
    @JsonProperty("state")
    private String state;
    @JsonProperty("city")
    private String city;
    @JsonProperty("neighborhood")
    private String neighborhood;
    @JsonProperty("street")
    private String street;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("number")
    private String number;
    @JsonProperty("completeAddress")
    private String completeAddress;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("receiverName")
    private String receiverName;

    protected BuyerAddressResource() {
        // Construtor vazio para serialização
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getComment() {
        return comment;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getReceiverName() {
        return receiverName;
    }
}