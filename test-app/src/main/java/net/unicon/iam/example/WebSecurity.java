package net.unicon.iam.example;

import org.pac4j.core.config.Config;
import org.pac4j.springframework.security.web.CallbackFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebSecurity {

    @Bean("webSecurityConfig")
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(final Config config) {
        return new Pac4jWebSecurityConfigurerAdapter(config);
    }

    public static class Pac4jWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        private final Config config;

        public Pac4jWebSecurityConfigurerAdapter(final Config config) {
            this.config = config;
        }

            @Override
        protected void configure(HttpSecurity http) throws Exception {
            final CallbackFilter callbackFilter = new CallbackFilter(this.config);
            http.antMatcher("/**").addFilterBefore(callbackFilter, BasicAuthenticationFilter.class);
/*
            http.authorizeRequests().anyRequest().fullyAuthenticated();

            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

            http.csrf().disable();
            http.headers().frameOptions().disable();
*/
        }
    }
}
