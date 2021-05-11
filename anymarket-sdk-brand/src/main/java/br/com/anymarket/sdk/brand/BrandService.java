package br.com.anymarket.sdk.brand;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.brand.dto.Brand;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.paging.Page;
import br.com.anymarket.sdk.util.SDKUrlEncoder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.apache.http.HttpStatus;

import java.util.List;

import static br.com.anymarket.sdk.http.headers.AnymarketHeaderUtils.addModuleOriginHeader;
import static java.lang.String.format;

public class BrandService extends HttpService {

    private static final String BRANDS_URI = "/brands";
    private final String apiEndPoint;
    private String moduleOrigin;

    public BrandService(String apiEndPoint) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public BrandService(String apiEndPoint, String origin) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        this.moduleOrigin = origin;
    }

    public Brand insertBrand(Brand brand, IntegrationHeader... headers) {
        RequestBodyEntity post = post(apiEndPoint.concat(BRANDS_URI), brand, addModuleOriginHeader(headers, this.moduleOrigin));
        Response response = execute(post);
        return response.to(Brand.class);
    }

    public Brand insertBrandIfNotExists(final String brandName, IntegrationHeader... headers) {
        final List<Brand> brands = getBrandsByName(brandName, headers);
        if (brands.isEmpty()) {
            return insertBrand(new Brand(brandName), headers);
        }
        if (brands.size() > 1) {
            throw new IllegalStateException("More than one brand found for name " + brandName);
        }
        return brands.get(0);
    }

    public Brand updateBrand(Brand brand, IntegrationHeader... headers) {
        RequestBodyEntity put = put(apiEndPoint.concat(BRANDS_URI).concat("/")
            .concat(brand.getId().toString()), brand, addModuleOriginHeader(headers, this.moduleOrigin));
        Response response = execute(put);
        return response.to(Brand.class);
    }

    public Brand getBrand(Long id, IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint.concat(BRANDS_URI).concat("/").concat(id.toString()), addModuleOriginHeader(headers, this.moduleOrigin));
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(Brand.class);
        }
        throw new NotFoundException(format("Brand with id %s not found.", id));
    }

    public List<Brand> getBrandsByName(final String name, IntegrationHeader... headers) {
        return getAllBrands(apiEndPoint.concat(BRANDS_URI).concat("?name=").concat(SDKUrlEncoder.encodeParameterToUTF8(name)), headers);
    }

    public List<Brand> getAllBrands(IntegrationHeader... headers) {
        return getAllBrands(apiEndPoint.concat(BRANDS_URI), headers);
    }

    private List<Brand> getAllBrands(final String url, IntegrationHeader... headers) {
        final List<Brand> allBrands = Lists.newArrayList();
        final GetRequest getRequest = get(url, addModuleOriginHeader(headers, this.moduleOrigin));
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            Page<Brand> rootResponse = response.to(new TypeReference<Page<Brand>>() {
            });
            allBrands.addAll(rootResponse.getContent());
        } else {
            throw new NotFoundException("Brands not found.");
        }
        return allBrands;
    }
}
