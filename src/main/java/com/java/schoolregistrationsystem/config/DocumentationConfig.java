package com.java.schoolregistrationsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class DocumentationConfig {
    @Bean
    public Docket swaggerConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "School Registration System",
                "System designed to allow students to register for selected courses",
                "1.0",
                "Free to use",
                new Contact("Mikołaj Bzdoń", "https://www.instagram.com/mts_software/", "bzdonmikolaj@gmail.com"),
                "API License",
                "https://pl.wikipedia.org/wiki/Jan_Pawe%C5%82_II",
                Collections.emptyList());
    }
}
