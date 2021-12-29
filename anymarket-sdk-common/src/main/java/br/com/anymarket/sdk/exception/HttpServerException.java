package br.com.anymarket.sdk.exception;

/**
 * Created by marcio.scharam on 18/03/2016.
 */
public class HttpServerException extends AnymarketSDKException {

    private final Integer statusCode;

    public HttpServerException(Integer statusCode, String message) {
        this(statusCode, message, null);
    }

    public HttpServerException(Integer statusCode, String message, String details) {
        super(message, details);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
