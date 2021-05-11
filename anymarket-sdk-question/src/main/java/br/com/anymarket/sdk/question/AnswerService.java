package br.com.anymarket.sdk.question;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.question.dto.Answer;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.apache.http.HttpStatus;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

public class AnswerService extends HttpService {

    private static final String ANSWER_URI = "/questions/%s/answers/";

    private String apiEndPoint;

    public AnswerService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public Answer insertAnswer(final Answer answer, final Long idQuestion, IntegrationHeader... headers) {
        checkNotNull(answer, "Informe a resposta a ser persistida.");
        checkNotNull(idQuestion, "Informe o id da questão.");
        RequestBodyEntity post = post(getURLFormated(idQuestion), answer, headers);
        Response response = execute(post);
        return response.to(Answer.class);
    }

    public Answer getAnswer(final Long idQuestion, final Long idAnswer, IntegrationHeader... headers) {
        checkNotNull(idQuestion, "Informe o id do questão.");
        checkNotNull(idAnswer, "Informe o id da resposta.");
        GetRequest getRequest = get(getURLFormated(idQuestion) + idAnswer, headers);
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(Answer.class);
        }
        throw new NotFoundException(format("Answer with id %s and question id %s not found.", idAnswer, idQuestion));
    }

    private String getURLFormated(final Long idQuestion) {
        return String.format(apiEndPoint.concat(ANSWER_URI), idQuestion.toString());
    }
}
