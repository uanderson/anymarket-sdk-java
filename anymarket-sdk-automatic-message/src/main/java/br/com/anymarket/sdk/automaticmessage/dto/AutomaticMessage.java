package br.com.anymarket.sdk.automaticmessage.dto;


public class AutomaticMessage {

    private Long id;
    private String message;

    public AutomaticMessage(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public AutomaticMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
