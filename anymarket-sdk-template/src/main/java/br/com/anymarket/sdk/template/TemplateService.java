package br.com.anymarket.sdk.template;

import br.com.anymarket.sdk.MarketPlace;
import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.paging.Page;
import br.com.anymarket.sdk.template.dto.Template;
import br.com.anymarket.sdk.util.SDKUrlEncoder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mashape.unirest.request.GetRequest;
import org.apache.http.HttpStatus;

import java.util.List;

import static java.lang.String.format;

public class TemplateService extends HttpService {

    private static final String TEMPLATE_URI = "/template";
    private final String apiEndPoint;

    public TemplateService(String apiEndPoint) {
        this.apiEndPoint = !Strings.isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public Template getTemplate(Long id, IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint + TEMPLATE_URI + id, headers);
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(Template.class);
        }
        throw new NotFoundException(format("Template with id %s not found.", id));
    }

    public List<Template> getTemplatesByMarketPlace(final MarketPlace marketPlace, IntegrationHeader... headers) {
        return getTemplateList(apiEndPoint.concat(TEMPLATE_URI).concat("?name=").concat(SDKUrlEncoder.encodeParameterToUTF8(marketPlace.name())), headers);
    }

    private List<Template> getTemplateList(final String url, IntegrationHeader... headers) {
        final List<Template> templates = Lists.newArrayList();
        final GetRequest getRequest = get(url, headers);
        final Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            Page<Template> rootResponse = response.to(new TypeReference<Page<Template>>() {
            });
            templates.addAll(rootResponse.getContent());
        } else {
            throw new NotFoundException("Templates not found.");
        }
        return templates;
    }

}
