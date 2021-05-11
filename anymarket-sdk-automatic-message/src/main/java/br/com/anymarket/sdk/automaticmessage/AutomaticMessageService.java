package br.com.anymarket.sdk.automaticmessage;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.automaticmessage.dto.AutomaticMessage;
import com.mashape.unirest.request.body.RequestBodyEntity;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

public class AutomaticMessageService extends HttpService {

    private static final String AUTOMATIC_MESSAGE_URI = "/messages/order/%s";

    private String apiEndPoint;

    public AutomaticMessageService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public AutomaticMessage insertAutomaticMessage(final AutomaticMessage message, IntegrationHeader... headers) {
        checkNotNull(message.getId(), "Informe o id do pedido.");
        RequestBodyEntity post = post(getURLFormated(message.getId()), message, headers);
        Response response = execute(post);
        return response.to(AutomaticMessage.class);
    }

    private String getURLFormated(final Long idOrder) {
        return String.format(apiEndPoint.concat(AUTOMATIC_MESSAGE_URI), idOrder.toString());
    }
}
