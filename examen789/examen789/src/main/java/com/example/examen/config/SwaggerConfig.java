package com.example.examen.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket confiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
            "Spring boot Book API REST para negocio de tecnología", 
            "Api para la gestión de laptop", "0.0.1", 
            "https://wwww.google.com",
            new Contact("Omar Yarleque", "https://github.com/omaryp", 
            "algo@gmail.com"),"MIT", "https://wwww.google.com", Collections.emptyList());
    }
    
}
