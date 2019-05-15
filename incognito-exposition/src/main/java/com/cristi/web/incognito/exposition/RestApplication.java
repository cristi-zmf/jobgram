package com.cristi.web.incognito.exposition;

import com.cristi.web.incognito.incognito.application.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

//@IncognitoMapping
@SpringBootApplication
@Import(ApplicationConfig.class)
public class RestApplication extends SpringBootServletInitializer {
//    private static Class<RestApplication> applicationClass = RestApplication.class;
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestApplication.class);
    }
}
