package br.com.anymarket.sdk.variation;

import br.com.anymarket.sdk.SDKConstants;
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

import static java.lang.String.format;

public class VariationService extends HttpService {

    private static final String VARIATIONS_URI = "/variations";
    private final String apiEndPoint;

    public VariationService(String apiEndPoint) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public VariationType insertType(VariationType type, IntegrationHeader... headers) {
        RequestBodyEntity post = post(apiEndPoint.concat(VARIATIONS_URI), type, headers);
        Response response = execute(post);
        return response.to(VariationType.class);
    }

    public VariationType insertTypeIfNotExists(final String typeName, IntegrationHeader... headers) {
        final List<VariationType> types = getTypesByName(typeName, headers);
        if (types.isEmpty()) {
            return insertType(new VariationType(typeName), headers);
        }
        if (types.size() > 1) {
            throw new IllegalStateException("More than one VariationType found for name " + typeName);
        }
        return types.get(0);
    }

    public VariationType updateType(VariationType type, IntegrationHeader... headers) {
        String url = apiEndPoint.concat(VARIATIONS_URI).concat("/").concat(type.getId().toString());
        RequestBodyEntity put = put(url, type, headers);
        Response response = execute(put);
        return response.to(VariationType.class);
    }

    public Variation insertTypeValue(VariationType type, Variation value, IntegrationHeader... headers) {
        String url = apiEndPoint.concat(VARIATIONS_URI)
            .concat("/").concat(type.getId().toString())
            .concat("/").concat("values");
        RequestBodyEntity post = post(url, value, headers);
        Response response = execute(post);
        return response.to(Variation.class);
    }

    public VariationType getType(Long id, IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint.concat(VARIATIONS_URI).concat("/").concat(id.toString()), headers);
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(VariationType.class);
        }
        throw new NotFoundException(format("VariationType with id %s not found.", id));
    }

    public List<VariationType>  getTypesByName(final String name, IntegrationHeader... headers) {
        return getAllTypes(apiEndPoint.concat(VARIATIONS_URI).concat("?name=").concat(SDKUrlEncoder.encodeParameterToUTF8(name)), headers);
    }

    public List<VariationType> getAllTypes(IntegrationHeader... headers) {
        return getAllTypes(apiEndPoint.concat(VARIATIONS_URI), headers);
    }

    private List<VariationType> getAllTypes(final String url, IntegrationHeader... headers) {
        final List<VariationType> allTypes = Lists.newArrayList();
        final GetRequest getRequest = get(url, headers);
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            Page<VariationType> rootResponse = response.to(new TypeReference<Page<VariationType>>() {
            });
            allTypes.addAll(rootResponse.getContent());
        } else {
            throw new NotFoundException("VariationTypes not found.");
        }
        return allTypes;
    }

    public List<VariationType> getAllTypesNotPaged(IntegrationHeader... headers){
        final List<VariationType> allTypes = Lists.newArrayList();
        final GetRequest getRequest = get(apiEndPoint.concat(VARIATIONS_URI).concat("/all"), headers);
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            List<VariationType> rootResponse = response.to(new TypeReference<List<VariationType>>() {
            });
            allTypes.addAll(rootResponse);
        }else {
            throw new NotFoundException("VariationType not found");
        }
        return allTypes;
    }
}
