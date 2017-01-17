package br.com.anymarket.sdk.exception;

/**
 * Created by marcio.scharam on 18/03/2016.
 */
public abstract class AnymarketSDKException extends RuntimeException {
    private String details;

    public AnymarketSDKException(String message) {
        super(message);
    }

    public AnymarketSDKException(String message, String details) {
        super(message);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
