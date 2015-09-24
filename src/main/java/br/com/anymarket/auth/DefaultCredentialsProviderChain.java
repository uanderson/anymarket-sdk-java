package br.com.anymarket.auth;

public class DefaultCredentialsProviderChain extends CredentialsProviderChain {

    public DefaultCredentialsProviderChain() {
        super(
            new EnvironmentCredentialsProvider(),
            new SystemPropertiesCredentialsProvider()
        );
    }

}
