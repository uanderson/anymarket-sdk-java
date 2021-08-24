package br.com.anymarket.sdk.order;

import br.com.anymarket.sdk.MarketPlace;
import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.order.dto.OrderReservation;

import static br.com.anymarket.sdk.http.headers.AnymarketHeaderUtils.addModuleOriginHeader;
import static br.com.anymarket.sdk.http.restdsl.AnyMarketRestDSL.*;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

public class OrderReservationService {

    public static final String ORDERS_RESERVATIONS = "/orders/reservations";
    private String apiEndPointForResource;
    private String moduleOrigin;

    public OrderReservationService(String apiEndPoint) {
        this.apiEndPointForResource = !isNullOrEmpty(apiEndPoint)
            ? apiEndPoint
            : SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public OrderReservationService(String apiEndPoint, String origin) {
        this.apiEndPointForResource = !isNullOrEmpty(apiEndPoint)
                ? apiEndPoint
                : SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        this.moduleOrigin = origin;
    }

    public OrderReservation getOrderReservation(Long idOrder, IntegrationHeader... headers) {
        checkNotNull(idOrder, "Erro ao recuperar reserva do pedido: Id não informado");
        return get(apiEndPointForResource.concat(ORDERS_RESERVATIONS))
            .headers(addModuleOriginHeader(headers, this.moduleOrigin))
            .queryString("id", idOrder.toString())
            .getResponse()
            .to(OrderReservation.class);
    }

    public OrderReservation getOrderReservationByIdInMarketplace(String idInMarketplace, MarketPlace marketPlace, IntegrationHeader... headers) {
        checkNotNull(idInMarketplace, "Erro ao recuperar reserva do pedido: Id no Marketplace não informado");
        checkNotNull(marketPlace, "Erro ao recuperar reserva do pedido: Marketplace não informado");
        return get(apiEndPointForResource.concat(ORDERS_RESERVATIONS))
            .headers(addModuleOriginHeader(headers, this.moduleOrigin))
            .queryString("idInMarketplace", idInMarketplace)
            .queryString("marketplace", marketPlace.name())
            .getResponse()
            .to(OrderReservation.class);
    }

    public OrderReservation createOrderReservation(OrderReservation orderReservation, IntegrationHeader... headers) {
        checkNotNull(orderReservation, "Erro ao criar reserva do pedido: Dados da reserva devem ser informados");
        return post(apiEndPointForResource.concat(ORDERS_RESERVATIONS))
            .body(orderReservation)
            .headers(addModuleOriginHeader(headers, this.moduleOrigin))
            .getResponse()
            .to(OrderReservation.class);
    }

    public void cancelOrderReservation(Long idOrder, IntegrationHeader... headers) {
        checkNotNull(idOrder, "Erro ao cancelar a reserva do pedido: Id não informado");
        put(apiEndPointForResource.concat(ORDERS_RESERVATIONS).concat("/{id}/cancel"))
            .routeParam("id", idOrder.toString())
            .headers(addModuleOriginHeader(headers, this.moduleOrigin))
            .getResponse();
    }

}
