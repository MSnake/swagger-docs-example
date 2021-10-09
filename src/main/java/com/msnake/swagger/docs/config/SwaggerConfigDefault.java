package com.msnake.swagger.docs.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Конфигурация swagger-документации
 */
@Configuration
@ConditionalOnProperty(name = "application.type-doc.advanced", havingValue = "false")
public class SwaggerConfigDefault {

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json"));

    private String getBaseControllersPackage() {
        return "com.msnake.swagger.docs";
    }

    private String getTitle() {
        return "SWAGGER-DOCS REST API";
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage(getBaseControllersPackage()))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(getTitle())
                .build();
    }
}
