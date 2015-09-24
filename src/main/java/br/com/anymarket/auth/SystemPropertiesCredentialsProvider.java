package br.com.anymarket.auth;

import br.com.anymarket.ClientException;

import static java.text.MessageFormat.format;

public class SystemPropertiesCredentialsProvider implements CredentialsProvider {

    private static final String ANYMARKET_TOKEN= "anymarket.token";

    @Override
    public Credentials getCredentials() {
        String token = System.getProperty(ANYMARKET_TOKEN);

        if (token != null) {
            return new BasicCredentials(token);
        }

        throw new ClientException(format("Not found system property variables {0}", ANYMARKET_TOKEN));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
