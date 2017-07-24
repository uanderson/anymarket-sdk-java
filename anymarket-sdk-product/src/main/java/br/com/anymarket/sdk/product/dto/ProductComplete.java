package br.com.anymarket.sdk.product.dto;


import br.com.anymarket.sdk.variation.Variation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

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

        Collections.sort(images, getImageComparator());
        return images;
    }

    private Comparator<Image> getImageComparator() {
        return new Comparator<Image>() {
            @Override
            public int compare(Image o1, Image o2) {
                if (o1.getVariation() != null) {
                    if (o2.getVariation() != null) {
                        return Integer.valueOf(o1.getIndex()).compareTo(o2.getIndex());
                    } else {
                        return -1;
                    }
                }
                if (o1.getVariation() == null) {
                    if (o2.getVariation() != null) {
                        return 1;
                    } else {
                        return Integer.valueOf(o1.getIndex()).compareTo(o2.getIndex());
                    }
                }
                return 0;
            }
        };
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
