package br.com.anymarket.sdk.product;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.product.dto.Image;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.GetRequest;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static br.com.anymarket.sdk.http.headers.AnymarketHeaderUtils.addModuleOriginHeader;
import static com.google.common.base.Strings.isNullOrEmpty;

public class ImageService extends HttpService {
    private static final String IMAGE_URI = "/products/%s/images";
    private final String apiEndPoint;
    private String moduleOrigin;

    public ImageService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public ImageService(String apiEndPoint, String origin) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        this.moduleOrigin = origin;
    }

    private String getURLFormated(final Long idProduct) {
        return String.format(apiEndPoint.concat(IMAGE_URI), idProduct.toString());
    }

    public List<Image> getAllImages(final Long idProduct, IntegrationHeader... headers) {
        return getAllImages(idProduct, Image.class, headers);
    }

    public <T> List<Image> getAllImages(final Long idProduct, Class<T> clazz, IntegrationHeader... headers) {
        List<Image> allimages = Lists.newArrayList();
        final GetRequest getRequest = get(getURLFormated(idProduct).concat("/"), addModuleOriginHeader(headers, this.moduleOrigin));
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            Image[] lstImg = response.to(Image[].class);
            allimages = Arrays.asList(lstImg);
        } else {
            throw new NotFoundException("Images not found.");
        }
        return allimages;
    }
}
