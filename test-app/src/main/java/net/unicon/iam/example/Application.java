package net.unicon.iam.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "org.pac4j.springframework.annotation", "org.pac4j.springframework.component", "org.pac4j.springframework.web", "net.unicon.iam" })
@ComponentScan(basePackages = { "net.unicon.iam" })
public class Application extends SpringBootServletInitializer {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
