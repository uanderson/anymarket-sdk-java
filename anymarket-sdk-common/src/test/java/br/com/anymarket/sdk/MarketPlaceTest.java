package br.com.anymarket.sdk;

import org.junit.Test;

import static org.junit.Assert.fail;

public class MarketPlaceTest {

    @Test
    public void should_have_unique_short_names() {
        for(final MarketPlace marketPlace : MarketPlace.values()) {
            for(MarketPlace marketPlace2 : MarketPlace.values()) {
                if(marketPlace != marketPlace2
                        && !marketPlace.getShortName().equals("B2W")
                        && marketPlace.getShortName().equals(marketPlace2.getShortName())) {
                    fail(String.format("%s e %s possuem o mesmo shortName", marketPlace, marketPlace2));
                }
            }
        }
    }
}