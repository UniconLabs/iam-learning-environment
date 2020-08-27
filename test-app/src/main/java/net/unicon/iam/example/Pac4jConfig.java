package net.unicon.iam.example;

import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Pac4jConfig {

    @Bean
    public Config config() {
        final CasConfiguration configuration = new CasConfiguration("https://cas.unicon.local/cas/login");
        final CasClient casClient = new CasClient(configuration);

        final Clients clients = new Clients("https://test-app.unicon.local/callback", casClient);

        final Config config = new Config(clients);
        return config;
    }
}
