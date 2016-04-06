package br.com.anymarket.sdk.order;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.http.restdsl.RestResponse;
import br.com.anymarket.sdk.order.dto.Order;
import br.com.anymarket.sdk.order.filters.OrderFilter;
import br.com.anymarket.sdk.paging.Page;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import static br.com.anymarket.sdk.http.restdsl.AnyMarketRestDSL.*;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

public class OrderService {

    private String apiEndPointForResource;

    public OrderService(String apiEndPoint) {
        this.apiEndPointForResource = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public RestResponse getOrder(Long idOrder, IntegrationHeader... headers) {
        checkNotNull(idOrder, "Erro ao recuperar pedido: Id não informado");
        return get(apiEndPointForResource.concat("/orders/{id}"))
            .headers(headers)
            .routeParam("id", idOrder.toString())
            .getResponse();
    }

    public RestResponse getOrderByPartnerId(String partnerId, IntegrationHeader... headers) {
        checkNotNull(partnerId, "Erro ao recuperar pedido: Id não informado");
        return get(apiEndPointForResource.concat("/orders/{id}"))
                .headers(headers)
                .routeParam("id", partnerId)
                .getResponse();
    }


    public RestResponse getOrders(List<OrderFilter> filters, IntegrationHeader... headers) {
        return get(apiEndPointForResource.concat("/orders"))
            .headers(headers)
            .filters(filters)
            .getResponse();
    }

    public RestResponse createOrder(Order order, IntegrationHeader... headers) {
        checkNotNull(order, "Erro ao criar pedido: Dados enão encontrados.");
        return post(apiEndPointForResource.concat("/orders"))
            .headers(headers)
            .getResponse();
    }

    public RestResponse updateOrder(Order order, IntegrationHeader... headers) {
        checkNotNull(order, "Erro ao atualizar pedido: Dados enão encontrados.");
        checkNotNull(order.getId(), "Erro ao atualizar pedido: Id não informado");
        return put(apiEndPointForResource.concat("/orders/{id}"))
            .headers(headers)
            .routeParam("id", order.getId().toString())
            .getResponse();
    }
}
