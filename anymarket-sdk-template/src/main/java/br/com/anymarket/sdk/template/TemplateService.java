package br.com.anymarket.sdk.template;

import br.com.anymarket.sdk.MarketPlace;
import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.HttpClientException;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.template.dto.Template;
import br.com.anymarket.sdk.util.SDKUrlEncoder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.GetRequest;
import org.apache.http.HttpStatus;

import java.util.List;

import static br.com.anymarket.sdk.http.headers.AnymarketHeaderUtils.addModuleOriginHeader;
import static java.lang.String.format;

public class TemplateService extends HttpService {

    private static final String TEMPLATE_URI = "/template";
    public static final String SEPARATOR = "/";
    private final String apiEndPoint;
    private String moduleOrigin;

    public TemplateService(String apiEndPoint) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public TemplateService(String apiEndPoint, String origin) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
        this.moduleOrigin = origin;
    }

    public Template getTemplate(Long id, IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint + TEMPLATE_URI + SEPARATOR + id, addModuleOriginHeader(headers, this.moduleOrigin));
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(Template.class);
        }
        throw new NotFoundException(format("Template with id %s not found.", id));
    }

    public List<Template> getTemplatesByMarketPlace(final MarketPlace marketPlace, IntegrationHeader... headers) {
        return getTemplateList(apiEndPoint.concat(TEMPLATE_URI).concat("/list/")
            .concat(SDKUrlEncoder.encodeParameterToUTF8(marketPlace.name())),
            addModuleOriginHeader(headers, this.moduleOrigin));
    }

    public String renderTemplate(Long templateId, Long skuMpId, IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint + TEMPLATE_URI + "/render/" + templateId + SEPARATOR + skuMpId, addModuleOriginHeader(headers, this.moduleOrigin));
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.getMessage();
        }
        throw new HttpClientException(format("Could not render template with id %d for sku id %d", templateId, skuMpId));
    }


    private List<Template> getTemplateList(final String url, IntegrationHeader... headers) {
        final List<Template> templates = Lists.newArrayList();
        final GetRequest getRequest = get(url, addModuleOriginHeader(headers, this.moduleOrigin));
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            List<Template> rootResponse = response.to(new TypeReference<List<Template>>() {
            });
            templates.addAll(rootResponse);
        } else {
            throw new NotFoundException("Template not found.");
        }
        return templates;
    }

}
