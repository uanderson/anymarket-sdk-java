package br.com.anymarket.sdk.question;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.exception.NotFoundException;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.question.dto.Question;
import com.mashape.unirest.request.GetRequest;
import org.apache.http.HttpStatus;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

public class QuestionService extends HttpService {

    private static final String QUESTION_URI = "/questions/";

    private String apiEndPoint;

    public QuestionService(String apiEndPoint) {
        this.apiEndPoint = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
                SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public Question getQuestion(Long id, IntegrationHeader... headers) {
        GetRequest getRequest = get(apiEndPoint + QUESTION_URI + id, headers);
        Response response = execute(getRequest);
        if (response.getStatus() == HttpStatus.SC_OK) {
            return response.to(Question.class);
        }
        throw new NotFoundException(format("Question with id %s not found.", id));
    }
}
