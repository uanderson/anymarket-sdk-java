package br.com.anymarket.sdk.product;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.paging.Page;
import br.com.anymarket.sdk.product.dto.Image;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.GetRequest;
import org.apache.http.HttpStatus;

import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;

public class ImageService extends HttpService {
    private static final String IMAGE_URI = "/products/%s/images";
    private final String apiEndPoint;

    public ImageService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    private String getURLFormated(final Long idProduct) {
        return String.format(apiEndPoint.concat(IMAGE_URI), idProduct.toString());
    }

    public List<Image> getAllImages(final Long idProduct, IntegrationHeader... headers) {
        return getAllImages(idProduct, Image.class, headers);
    }

    public <T> List<T> getAllImages(final Long idProduct, Class<T> clazz, IntegrationHeader... headers) {
        final List<T> allimages = Lists.newArrayList();
        final GetRequest getRequest = get(getURLFormated(idProduct).concat("/"), headers);
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            Page<T> rootResponse = response.to(new TypeReference<Page<T>>() {
            });
            allimages.addAll(rootResponse.getContent());
        } else {
            throw new NotFoundException("Images not found.");
        }
        return allimages;
    }
}
