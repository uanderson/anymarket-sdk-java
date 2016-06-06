package br.com.anymarket.sdk.product;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.paging.Page;
import br.com.anymarket.sdk.product.dto.Sku;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

public class SkuService extends HttpService {

    private static final String SKU_URI = "/products/%s/skus/";
    private final String apiEndPoint;

    public SkuService(final String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    private String getURLFormated(final Long idProduct) {
        return String.format(apiEndPoint.concat(SKU_URI), idProduct.toString());
    }

    public Sku insertSku(final Sku sku, final Long idProduct, IntegrationHeader... headers) {
        Objects.requireNonNull(sku, "Informe o Sku a ser persistido.");
        Objects.requireNonNull(idProduct, "Informe o id do produto do Sku.");
        RequestBodyEntity post = post(getURLFormated(idProduct), sku, headers);
        Response response = execute(post);
        return response.to(Sku.class);
    }

    public Sku updateSku(final Sku sku, final Long idProduct, IntegrationHeader... headers) {
        Objects.requireNonNull(sku, "Informe o Sku a ser atualizado.");
        Objects.requireNonNull(idProduct, "Informe o id do produto do Sku.");
        RequestBodyEntity put = put(getURLFormated(idProduct).concat("/").concat(sku.getId().toString()), sku, headers);
        Response response = execute(put);
        return response.to(Sku.class);
    }

    public Sku insertOrUpdateSku(final Sku sku, final Long idProduct, IntegrationHeader... headers) {
        if (sku.getId() != null) {
            return updateSku(sku, idProduct, headers);
        } else {
            return insertSku(sku, idProduct, headers);
        }
    }

    public Sku getSku(Long idSku, final Long idProduct, IntegrationHeader... headers) {
        Objects.requireNonNull(idSku, "Informe o id do Sku.");
        Objects.requireNonNull(idProduct, "Informe o id do produto do Sku.");
        GetRequest getRequest = get(getURLFormated(idProduct).concat("/").concat(idSku.toString()), headers);
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(Sku.class);
        }
        throw new NotFoundException(format("Sku with id %s and product id %s not found.", idSku, idProduct));
    }

    public List<Sku> getAllSkus(final Long idProduct, IntegrationHeader... headers) {
        final List<Sku> allSkus = Lists.newArrayList();
        final GetRequest getRequest = get(getURLFormated(idProduct).concat("/"), headers);
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            Page<Sku> rootResponse = response.to(new TypeReference<Page<Sku>>() {
            });
            allSkus.addAll(rootResponse.getContent());
        } else {
            throw new NotFoundException("Skus not found.");
        }
        return allSkus;
    }

}
