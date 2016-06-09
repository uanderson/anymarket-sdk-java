package br.com.anymarket.sdk.product.dto;

import br.com.anymarket.sdk.dto.AvailableStockDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by fernando.gomes on 31/05/2016.
 */
public class UpdatePublicationStatusDTO {

    @JsonProperty("actualPublication")
    private SkuMarketPlace actualPublication;
    @JsonProperty("actualStock")
    private AvailableStockDTO actualStock;
    @JsonProperty("newStatus")
    private PublicationStatus newStatus;
    @JsonProperty("newStatus")
    private String oi;


    public SkuMarketPlace getActualPublication() {
        return actualPublication;
    }

    public void setActualPublication(SkuMarketPlace actualPublication) {
        this.actualPublication = actualPublication;
    }

    public AvailableStockDTO getActualStock() {
        return actualStock;
    }

    public void setActualStock(AvailableStockDTO actualStock) {
        this.actualStock = actualStock;
    }

    public PublicationStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(PublicationStatus newStatus) {
        this.newStatus = newStatus;
    }

    public String getOi() {
        return oi;
    }

    public void setOi(String oi) {
        this.oi = oi;
    }
}
