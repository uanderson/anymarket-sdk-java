package br.com.anymarket.auth;

import br.com.anymarket.ClientException;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class CredentialsProviderChain implements CredentialsProvider {

    private static Logger LOG = LoggerFactory.getLogger(CredentialsProviderChain.class);

    private List<CredentialsProvider> providers = new LinkedList<CredentialsProvider>();

    public CredentialsProviderChain(CredentialsProvider... providers) {
        checkArgument(ArrayUtils.getLength(providers) > 0, "No credential providers informed");

        for (CredentialsProvider provider : providers) {
            this.providers.add(provider);
        }
    }

    @Override
    public Credentials getCredentials() {
        for (CredentialsProvider provider : providers) {
            try {
                Credentials credentials = provider.getCredentials();

                if (credentials.getToken() != null) {
                    return credentials;
                }
            } catch (Exception ex) {
                LOG.debug("Unable to load credentials from {}: {}", provider, ex.getMessage());
            }
        }

        throw new ClientException("Unable to load AnyMarket credentials from any provider in the chain");
    }
}
