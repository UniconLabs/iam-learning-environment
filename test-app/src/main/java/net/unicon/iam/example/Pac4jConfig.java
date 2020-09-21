package net.unicon.iam.example;

import org.pac4j.cas.client.CasClient;
import org.pac4j.core.client.Client;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.saml.client.SAML2Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Pac4jConfig {
    @Bean
    public Config config(final Pac4jConfigurationProperties pac4jConfigurationProperties) {
        List<Client> clientList = new ArrayList<>();

        SAML2Client saml2Client = new SAML2Client(pac4jConfigurationProperties.getSaml2());
        saml2Client.setName("SAML2Client");
        clientList.add(saml2Client);

        if (pac4jConfigurationProperties.getCas20() != null) {
            CasClient casClient = new CasClient(pac4jConfigurationProperties.getCas20());
            casClient.setName("CAS20Client");
            clientList.add(casClient);
        }

        Clients clients = new Clients(pac4jConfigurationProperties.getCallbackUrl(), clientList);
        Config config = new Config(clients);
        return config;
    }
}
