package net.unicon.iam.example;

import org.pac4j.core.config.Config;
import org.pac4j.core.http.adapter.JEEHttpActionAdapter;
//import org.pac4j.springframework.web.SecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class SecurityConfig implements WebMvcConfigurer {

/*    private final Config config;

    public SecurityConfig(Config config) {
        this.config = config;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // get interceptor for callback registration
        // change order?
        InterceptorRegistration ir = registry.addInterceptor(buildInterceptor("CasClient")).addPathPatterns("/*");
        ir.order(100);
    }

    private SecurityInterceptor buildInterceptor(final String client) {
        return new SecurityInterceptor(config, client, JEEHttpActionAdapter.INSTANCE);
    }*/
}
