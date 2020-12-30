package net.unicon.iam.example;

import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.oidc.config.OidcConfiguration;
import org.pac4j.saml.config.SAML2Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@Configuration
@ConfigurationProperties(prefix = "pac4j")
public class Pac4jConfigurationProperties {
    private String callbackUrl;
    private SAML2Configuration saml2;
    private CasConfiguration cas20;
    private OidcConfiguration oidc;

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public SAML2Configuration getSaml2() {
        return saml2;
    }

    public void setSaml2(SAML2Configuration saml2) {
        this.saml2 = saml2;
    }

    public CasConfiguration getCas20() {
        return cas20;
    }

    public void setCas20(CasConfiguration cas) {
        this.cas20 = cas;
    }

    public OidcConfiguration getOidc() {
        return oidc;
    }

    public void setOidc(OidcConfiguration oidc) {
        this.oidc = oidc;
    }
}
