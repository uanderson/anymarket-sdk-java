package br.com.anymarket.sdk.order;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.order.dto.Order;
import br.com.anymarket.sdk.order.filters.IGetOrderFilter;
import br.com.anymarket.sdk.paging.Page;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import static br.com.anymarket.sdk.http.restdsl.AnyMarketRestDSL.*;
import static com.google.common.base.Strings.isNullOrEmpty;

public class OrderService {

    private String apiEndPointForResource;

    public OrderService(String apiEndPoint) {
        if (isNullOrEmpty(apiEndPoint)) {
            apiEndPoint = SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        }
        this.apiEndPointForResource = apiEndPoint;
    }

    public List<Order> listOrders(Long idOrder, List<IGetOrderFilter> filters, IntegrationHeader... headers) {
        checkNotNull(idOrder, "Erro ao recuperar pedido: Id não informado");
        return get(apiEndPointForResource.concat("/orders"))
                .headers(headers)
                .routeParam("id", idOrder.toString())
                .getResponse()
                .to(new TypeReference<Page<Order>>(){})
                .getContent();
    }

    public Order getOrder(Long idOrder, List<IGetOrderFilter> filters, IntegrationHeader... headers) {
        checkNotNull(idOrder, "Erro ao recuperar pedido: Id não informado");
        return get(apiEndPointForResource.concat("/orders/{id}"))
                .headers(headers)
                .routeParam("id", idOrder.toString())
                .getResponse()
                .to(Order.class);
    }

    public Order createOrder(Order order, IntegrationHeader... headers) {
        checkNotNull(order, "Erro ao criar pedido: Dados enão encontrados.");
        return post(apiEndPointForResource.concat("/orders"))
                .headers(headers)
                .getResponse()
                .to(Order.class);
    }

    public Order updateOrder(Order order, IntegrationHeader... headers) {
        checkNotNull(order, "Erro ao atualizar pedido: Dados enão encontrados.");
        checkNotNull(order.getId(), "Erro ao atualizar pedido: Id não informado");
        return put(apiEndPointForResource.concat("/orders/{id}"))
                .headers(headers)
                .routeParam("id", order.getId().toString())
                .getResponse()
                .to(Order.class);
    }

    private void checkNotNull(Object obj, String errorMessage) {
        if (obj == null) {
            throw new RuntimeException(errorMessage);
        }
    }
}
