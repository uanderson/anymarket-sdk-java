package br.com.anymarket.auth;

import br.com.anymarket.ClientException;

import static java.text.MessageFormat.format;

public class EnvironmentCredentialsProvider implements CredentialsProvider {

    private static final String ANYMARKET_TOKEN = "ANYMARKET_TOKEN";

    @Override
    public Credentials getCredentials() {
        String token = System.getenv(ANYMARKET_TOKEN);

        if (token == null) {
            throw new ClientException(format("Not found environment variables {0}", ANYMARKET_TOKEN));
        }

        return new BasicCredentials(token);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
