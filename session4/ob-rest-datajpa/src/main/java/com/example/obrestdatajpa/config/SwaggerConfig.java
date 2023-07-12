package com.example.obrestdatajpa.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuracion swagger para generar la documentación de la API REST
 * HTML : http://localhost:8080/swagger-ui
 * JSON : http://localhost:8080/v2/api-docs
 */
@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
            "Spring boot Book API REST", 
            "Api para la gestión de libros", "0.0.1", 
            "https://wwww.google.com",
            new Contact("Omar Yarleque", "https://github.com/omaryp", 
            "algo@gmail.com"),"MIT", "https://wwww.google.com", Collections.emptyList());
    }

}