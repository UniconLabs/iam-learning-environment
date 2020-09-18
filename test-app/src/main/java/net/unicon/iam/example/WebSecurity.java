package net.unicon.iam.example;

import org.checkerframework.checker.units.qual.C;
import org.pac4j.core.authorization.authorizer.DefaultAuthorizers;
import org.pac4j.core.config.Config;
import org.pac4j.springframework.security.web.CallbackFilter;
import org.pac4j.springframework.security.web.SecurityFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
public class WebSecurity {
    @Configuration
    @Order(1)
    public static class SAML2WebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        private final Config pac4jConfig;

        public SAML2WebSecurityConfigurationAdapter(Config pac4jConfig) {
            this.pac4jConfig = pac4jConfig;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            final SecurityFilter securityFilter = new SecurityFilter(this.pac4jConfig, "SAML2Client", DefaultAuthorizers.NONE);

            http.antMatcher("/saml2/**")
                    .authorizeRequests()
                        .antMatchers("/saml2/**").authenticated()
                    .and()
                    .addFilterBefore(securityFilter, BasicAuthenticationFilter.class)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        }
    }

    @Configuration
    public static class DefaultWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        private final Config pac4jConfig;

        public DefaultWebSecurityConfigurationAdapter(Config pac4jConfig) {
            this.pac4jConfig = pac4jConfig;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            final CallbackFilter callbackFilter = new CallbackFilter(this.pac4jConfig);
            callbackFilter.setMultiProfile(true);

            http
                    .addFilterBefore(callbackFilter, BasicAuthenticationFilter.class)
                    .csrf().disable();
        }
    }
}
