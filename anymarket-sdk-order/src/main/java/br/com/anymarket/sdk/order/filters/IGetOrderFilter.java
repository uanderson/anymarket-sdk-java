package br.com.anymarket.sdk.order.filters;

/**
 * Created by marcos.trevisan on 31/03/2016.
 */
public interface IGetOrderFilter <T>{
    String getKey();
    T getValue();
}
