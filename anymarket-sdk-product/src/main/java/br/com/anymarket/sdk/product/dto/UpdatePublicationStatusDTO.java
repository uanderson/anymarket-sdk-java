package br.com.anymarket.sdk.product.dto;

import br.com.anymarket.sdk.dto.AvailableStockDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by fernando.gomes on 31/05/2016.
 */
public class UpdatePublicationStatusDTO implements Serializable {

    @JsonProperty("actualPublication")
    private SkuMarketPlace actualPublication;
    @JsonProperty("actualStock")
    private AvailableStockDTO actualStock;
    @JsonProperty("newStatus")
    private PublicationStatus newStatus;
    @JsonProperty("oi")
    private String oi;
    @JsonProperty("idSku")
    private Long idSku;
    @JsonProperty("onlySync")
    private boolean onlySync;

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

    public Long getIdSku() {
        return idSku;
    }

    public void setIdSku(Long idSku) {
        this.idSku = idSku;
    }

    public boolean isOnlySync() {
        return onlySync;
    }

    public void setOnlySync(boolean onlySync) {
        this.onlySync = onlySync;
    }
}
