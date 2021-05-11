package br.com.anymarket.sdk.order.filters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderPaymentExpiredDateFilter extends OrderFilter {

    static SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");

    public OrderPaymentExpiredDateFilter(Date value) {
        super(format.format(value));
    }

    @Override
    public String getKey() {
        return "paymentExpiredDate";
    }
}
