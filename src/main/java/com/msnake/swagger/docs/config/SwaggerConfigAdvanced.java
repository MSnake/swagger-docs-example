package com.msnake.swagger.docs.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Конфигурация swagger-документации
 */
@Configuration
@ConditionalOnProperty(name = "application.type-doc.advanced", havingValue = "true")
public class SwaggerConfigAdvanced {

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json"));

    @Autowired
    private BuildProperties buildProperties;

    private String getTitle() {
        return buildProperties.getName() + " REST API";
    }

    private String getDescription() {
        return "Project example for joker2021";
    }

    private String getAppVersion() {
        return buildProperties.getVersion();
    }

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        ConfigurableListableBeanFactory beanFactory = ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
        AtomicInteger count = new AtomicInteger();
        dockets().forEach(docket -> beanFactory.registerSingleton("Docket"+ count.getAndIncrement(), docket));
    }

    public List<Docket> dockets() {
        return Arrays.asList(new DocketInfo("1. Корзина покупок", Arrays.asList("/basket")),
                new DocketInfo("2. Скидки", Arrays.asList("/discount"))).stream()
                .map(data-> createDocket(data))
                .collect(Collectors.toList());
    }

//    @Bean
//    public Docket api() {
//        return getDocket()
//                .groupName("1. Корзина покупок")
//                .select()
//                //.paths(include("basket"))
//                .paths(PathSelectors.any())
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .build();
//    }

//    @Bean
//    public Docket api() {
//        return getDocket()
//                .groupName("02. Генератор")
//                .select()
//                .paths(include("generator", "tags", "translit_tables"))
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(getTitle())
                .description(getDescription())
                .version(getAppVersion())
                .build();
    }

    Predicate<String> include(final String... args) {
        return input -> {
            boolean contains = false;
            for (String arg : args) {
                contains = contains || input.contains(arg);
            }
            return contains;
        };
    }

    private Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

    private Docket createDocket(DocketInfo info) {
        Docket docket = getDocket();
        if (info.groupName !=null) {
            docket.groupName(info.groupName);
        }
        if (info.paths != null && !info.paths.isEmpty()) {
            return docket.select().paths(include(info.paths.stream().collect(Collectors.joining())))
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                    .build();
        } else {
            return docket.select().paths(PathSelectors.any())
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                    .build();
        }
    }

    class DocketInfo {
        String groupName;
        List<String> paths;
        public DocketInfo(String groupName, List<String> paths) {
            this.groupName = groupName;
            this.paths = paths;
        }
    }

}
