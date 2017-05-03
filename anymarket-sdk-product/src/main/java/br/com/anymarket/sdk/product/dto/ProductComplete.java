package br.com.anymarket.sdk.product.dto;


import br.com.anymarket.sdk.variation.Variation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductComplete extends ProductBase {

    @JsonProperty("skus")
    private List<SkuComplete> skus;

    public List<SkuComplete> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuComplete> skus) {
        this.skus = skus;
    }

    public List<Image> getImagesForSku(SkuComplete sku) {

        if (sku.getVariations().isEmpty()) {
            return this.getImagesWithoutVariationValue();
        } else {
            return this.getImagesByVariationValues(sku.getVariations());
        }
    }

    public List<Image> getImagesByVariationValues(List<Variation> variationValues) {
        List<Image> images = new ArrayList<Image>();
        for (Image image : this.getImages()) {
            for (Variation variation : variationValues) {
                if (hasNotVariationValue(image) || variation.getValue().equals(image.getVariation())) {
                    images.add(image);
                    break;
                }
            }

        }
        return images;
    }

    public List<Image> getImagesWithoutVariationValue() {
        List<Image> images = new ArrayList<Image>();
        for (Image image : this.getImages()) {
            if (hasNotVariationValue(image)) {
                images.add(image);
            }
        }
        return images;
    }

    private boolean hasNotVariationValue(Image image) {
        return isNullOrEmpty(image.getVariation());
    }

}
