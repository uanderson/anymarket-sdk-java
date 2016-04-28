package br.com.anymarket.sdk.product;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.paging.Page;
import br.com.anymarket.sdk.product.dto.Product;
import br.com.anymarket.sdk.util.SDKUrlEncoder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

public class ProductService extends HttpService {

    private static final String PRODUCTS_URI = "/products";
    private final String apiEndPoint;

    public ProductService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public Product insertProduct(Product product, IntegrationHeader... headers) {
        RequestBodyEntity post = post(apiEndPoint.concat(PRODUCTS_URI), product, headers);
        Response response = execute(post);
        return response.to(Product.class);
    }

    public Product updateProduct(Product product, IntegrationHeader... headers) {
        RequestBodyEntity put = put(apiEndPoint.concat(PRODUCTS_URI).concat("/")
            .concat(product.getId().toString()), product, headers);
        Response response = execute(put);
        return response.to(Product.class);
    }

    public Product getProduct(Long id, IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint.concat(PRODUCTS_URI).concat("/").concat(id.toString()), headers);
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(Product.class);
        }
        throw new NotFoundException(format("Product with id %s not found.", id));
    }

    public Product getProductBySku(final String sku, IntegrationHeader... headers) {
        final List<Product> products = getAllProducts(apiEndPoint.concat(PRODUCTS_URI).concat("?sku=").concat(SDKUrlEncoder.encodeParameterToUTF8(sku)), headers);
        if (!products.isEmpty()) {
            return products.stream().findFirst().get();
        }
        return null;
    }

    public List<Product> getAllProducts(IntegrationHeader... headers) {
        return getAllProducts(apiEndPoint.concat(PRODUCTS_URI).concat("/"), headers);
    }

    private List<Product> getAllProducts(final String url, IntegrationHeader... headers) {
        final List<Product> allProducts = new ArrayList<Product>();
        final GetRequest getRequest = get(url, headers);
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            Page<Product> rootResponse = response.to(new TypeReference<Page<Product>>() {
            });
            allProducts.addAll(rootResponse.getContent());
        } else {
            throw new NotFoundException("Products not found.");
        }
        return allProducts;
    }
}
