package net.unicon.iam.example;

import org.pac4j.cas.client.CasClient;
import org.pac4j.core.client.Client;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.oidc.client.OidcClient;
import org.pac4j.saml.client.SAML2Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Pac4jConfig {
    public static final String OIDC_CLIENT_NAME = "OIDCClient";

    @Bean
    public Config config(final Pac4jConfigurationProperties pac4jConfigurationProperties) {
        List<Client> clientList = new ArrayList<>();

        if (pac4jConfigurationProperties.getSaml2() != null) {
            SAML2Client saml2Client = new SAML2Client(pac4jConfigurationProperties.getSaml2());
            saml2Client.setName("SAML2Client");
            clientList.add(saml2Client);
        }

        if (pac4jConfigurationProperties.getCas20() != null) {
            CasClient casClient = new CasClient(pac4jConfigurationProperties.getCas20());
            casClient.setName("CAS20Client");
            clientList.add(casClient);
        }

        if (pac4jConfigurationProperties.getOidc() != null) {
            OidcClient oidcClient = new OidcClient(pac4jConfigurationProperties.getOidc());
            oidcClient.setName(OIDC_CLIENT_NAME);
            clientList.add(oidcClient);
        }

        Clients clients = new Clients(pac4jConfigurationProperties.getCallbackUrl(), clientList);
        Config config = new Config(clients);
        return config;
    }
}
