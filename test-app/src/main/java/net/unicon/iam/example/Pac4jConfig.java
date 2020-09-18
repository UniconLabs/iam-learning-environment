package net.unicon.iam.example;

import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.saml.client.SAML2Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Pac4jConfig {
    @Bean
    public Config config(final Pac4jConfigurationProperties pac4jConfigurationProperties) {
        SAML2Client saml2Client = new SAML2Client(pac4jConfigurationProperties.getSaml2());
        saml2Client.setName("SAML2Client");

        Clients clients = new Clients(pac4jConfigurationProperties.getCallbackUrl(), saml2Client);
        Config config = new Config(clients);
        return config;
    }
}
