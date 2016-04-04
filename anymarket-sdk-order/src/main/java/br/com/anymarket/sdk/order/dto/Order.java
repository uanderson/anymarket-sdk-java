package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("marketPlaceId")
    private String marketPlaceId;

    @JsonProperty("marketPlace")
    private MarketPlace marketPlace;

    @JsonProperty("partnerId")
    private String partnerId;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("transmissionStatus")
    private OrderTransmissionStatus transmissionStatus;

    @JsonProperty("status")
    private OrderStatus status;

    @JsonProperty("marketPlaceUrl")
    private String marketPlaceUrl;

    @JsonProperty("marketPlaceShipmentStatus")
    private String marketPlaceShipmentStatus;

    @JsonProperty("invoice")
    private InvoiceResource invoice;

    @JsonProperty("marketPlaceStatus")
    private String marketPlaceStatus;

    @JsonProperty("discount")
    private BigDecimal discount;

    @JsonProperty("freight")
    private BigDecimal freight;

    @JsonProperty("gross")
    private BigDecimal gross;

    @JsonProperty("total")
    private BigDecimal total;

    @JsonProperty("shipping")
    private ShippingResource shipping;

    @JsonProperty("buyer")
    private BuyerResource buyer;

    @JsonProperty("tracking")
    private TrackingResource tracking;

    @JsonProperty("payments")
    private List<PaymentResource> payments = new ArrayList();

    @JsonProperty("items")
    private List<OrderItemResource> items = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarketPlaceId() {
        return marketPlaceId;
    }

    public void setMarketPlaceId(String marketPlaceId) {
        this.marketPlaceId = marketPlaceId;
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public OrderTransmissionStatus getTransmissionStatus() {
        return transmissionStatus;
    }

    public void setTransmissionStatus(OrderTransmissionStatus transmissionStatus) {
        this.transmissionStatus = transmissionStatus;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getMarketPlaceUrl() {
        return marketPlaceUrl;
    }

    public void setMarketPlaceUrl(String marketPlaceUrl) {
        this.marketPlaceUrl = marketPlaceUrl;
    }

    public String getMarketPlaceShipmentStatus() {
        return marketPlaceShipmentStatus;
    }

    public void setMarketPlaceShipmentStatus(String marketPlaceShipmentStatus) {
        this.marketPlaceShipmentStatus = marketPlaceShipmentStatus;
    }

    public InvoiceResource getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceResource invoice) {
        this.invoice = invoice;
    }

    public String getMarketPlaceStatus() {
        return marketPlaceStatus;
    }

    public void setMarketPlaceStatus(String marketPlaceStatus) {
        this.marketPlaceStatus = marketPlaceStatus;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getGross() {
        return gross;
    }

    public void setGross(BigDecimal gross) {
        this.gross = gross;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ShippingResource getShipping() {
        return shipping;
    }

    public void setShipping(ShippingResource shipping) {
        this.shipping = shipping;
    }

    public BuyerResource getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerResource buyer) {
        this.buyer = buyer;
    }

    public TrackingResource getTracking() {
        return tracking;
    }

    public void setTracking(TrackingResource tracking) {
        this.tracking = tracking;
    }

    public List<PaymentResource> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentResource> payments) {
        this.payments = payments;
    }

    public List<OrderItemResource> getItems() {
        return items;
    }

    public void setItems(List<OrderItemResource> items) {
        this.items = items;
    }

}
