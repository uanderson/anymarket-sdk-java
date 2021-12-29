package br.com.anymarket.sdk.product;

import br.com.anymarket.sdk.MarketPlace;
import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.paging.Page;
import br.com.anymarket.sdk.product.dto.SkuMarketPlace;
import br.com.anymarket.sdk.product.dto.TransmissionDTO;
import br.com.anymarket.sdk.resource.Link;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Objects;

import static br.com.anymarket.sdk.http.headers.AnymarketHeaderUtils.addModuleOriginHeader;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

public class TransmissionService extends HttpService {

    private static final String TRANSMISSION_URI = "/transmissions/%s";
    private static final String TRANSMISSIONS_URI = "/transmissions";
    private static final String TRANSMISSIONS_BY_MARKETPLACE_URI = "/transmissions/marketplace/%s";
    public static final String NEXT = "next";

    private final String apiEndPoint;
    private String moduleOrigin;

    public TransmissionService(final String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public TransmissionService(final String apiEndPoint, String origin) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        this.moduleOrigin = origin;
    }

    public SkuMarketPlace updateStatus(final TransmissionDTO skuMp, Long idSkuMp, IntegrationHeader... headers) {
        Objects.requireNonNull(skuMp, "Informe o SkuMarketPlace a ser atualizado.");
        Objects.requireNonNull(idSkuMp, "Informe o id do SKU");
        RequestBodyEntity put = put(getURLFormated(idSkuMp), skuMp, addModuleOriginHeader(headers, this.moduleOrigin));
        Response response = execute(put);
        return response.to(SkuMarketPlace.class);
    }

    private String getURLFormated(final Long idSku) {
        return String.format(apiEndPoint.concat(TRANSMISSION_URI), idSku.toString());
    }

    private String getURLFormatedAll() {
        return apiEndPoint.concat(TRANSMISSIONS_URI);
    }

    public SkuMarketPlace getSkuMarketPlace(Long idSkuMp, IntegrationHeader... headers) {
        Objects.requireNonNull(idSkuMp, "Informe o id do SkuMarketPlace.");
        GetRequest getRequest = get(getURLFormated(idSkuMp), addModuleOriginHeader(headers, this.moduleOrigin));
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(SkuMarketPlace.class);
        }
        throw new NotFoundException(format("Sku with id %s not found.", idSkuMp));
    }

    public List<SkuMarketPlace> getAllSkuMps(IntegrationHeader... headers) {
        final List<SkuMarketPlace> allSkuMps = Lists.newArrayList();
        final GetRequest getRequest = get(getURLFormatedAll(), addModuleOriginHeader(headers, this.moduleOrigin));
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            Page<SkuMarketPlace> rootResponse = response.to(new TypeReference<Page<SkuMarketPlace>>() {
            });
            allSkuMps.addAll(rootResponse.getContent());
        } else {
            throw new NotFoundException("SkuMps not found.");
        }
        return allSkuMps;
    }

    public List<SkuMarketPlace> getAllSkuMPsFor(MarketPlace marketplace, IntegrationHeader... headers) {
        boolean hasMoreElements;

        final List<SkuMarketPlace> allSkuMps = Lists.newArrayList();
        String urlToGet = String.format(apiEndPoint.concat(TRANSMISSIONS_BY_MARKETPLACE_URI), marketplace.toString());
        do {
            final GetRequest getRequest = get(urlToGet, addModuleOriginHeader(headers, this.moduleOrigin));
            final Response response = execute(getRequest);
            if (response.getStatus() == HttpStatus.SC_OK) {
                Page<SkuMarketPlace> rootResponse = response.to(new TypeReference<Page<SkuMarketPlace>>() {});
                allSkuMps.addAll(rootResponse.getContent());

                hasMoreElements = !rootResponse.getContent().isEmpty();
                if(hasMoreElements) {
                    String nextURL = findNextURL(urlToGet, rootResponse);
                    if(urlToGet.equals(nextURL)) {
                        hasMoreElements = false;
                    } else {
                        urlToGet = nextURL;
                    }
                }
            } else {
                throw new NotFoundException("SkuMps not found.");
            }

        } while (hasMoreElements);

        return allSkuMps;
    }

    private String findNextURL(String urlToGet, Page<SkuMarketPlace> rootResponse) {
        for (Link link : rootResponse.getLinks()) {
            if (link.getRel().equals(NEXT)) {
                return link.getHref();
            }
        }
        return urlToGet;
    }
}
