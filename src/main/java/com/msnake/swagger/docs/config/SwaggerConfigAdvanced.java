package com.msnake.swagger.docs.config;

import com.fasterxml.classmate.TypeResolver;
import com.msnake.swagger.docs.utils.ExceptionJson;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Response;
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
@RequiredArgsConstructor
@ConditionalOnProperty(name = "application.type-doc.advanced", havingValue = "true")
public class SwaggerConfigAdvanced {

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json"));

    private final BuildProperties buildProperties;
    private final ApplicationContext applicationContext;
    private final TypeResolver typeResolver;

    @PostConstruct
    public void init() {
        ConfigurableListableBeanFactory beanFactory = ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
        AtomicInteger count = new AtomicInteger();
        dockets().forEach(docket -> beanFactory.registerSingleton("Docket" + count.getAndIncrement(), docket));
    }

    private String getTitle() {
        return buildProperties.getName().toUpperCase() + " REST API";
    }

    private String getAppVersion() {
        return buildProperties.getVersion();
    }

    public List<Docket> dockets() {
        return Arrays.asList(new DocketInfo("1. Авторизация", Arrays.asList("/auth")),
                new DocketInfo("2. Камунда", Arrays.asList("/camunda")),
                new DocketInfo("3. Основные функции", Arrays.asList("/basket", "/contragent", "/discount", "/product", "/shopping/cart", "/user")))
                .stream()
                .map(data -> createDocket(data))
                .collect(Collectors.toList());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(getTitle())
                .version(getAppVersion())
                .build();
    }

    private Docket getDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        List<Response> responseMessages = Arrays.asList(
                new ResponseBuilder().code("400").description("Данные запроса не корректны").build(),
                new ResponseBuilder().code("403").description("Недостаточно прав").build(),
                new ResponseBuilder().code("404").description("Запрашиваемый ресурс не найден").build(),
                new ResponseBuilder().code("500").description("Внутренняя ошибка сервера")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r -> r.model(m -> m.referenceModel(ref -> ref.key(k ->
                                k.qualifiedModelName(q -> q.namespace("com.msnake.swagger.docs.utils")
                                        .name("ExceptionJson"))))))
                        .build());
        return docket
                .apiInfo(apiInfo())
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET, responseMessages)
                .globalResponses(HttpMethod.POST, responseMessages)
                .globalResponses(HttpMethod.DELETE, responseMessages)
                .globalResponses(HttpMethod.PATCH, responseMessages)
                .globalResponses(HttpMethod.PUT, responseMessages)
                .additionalModels(typeResolver.resolve(ExceptionJson.class));
    }

    private Predicate<String> include(List<String> args) {
        return input -> {
            boolean contains = false;
            for (String arg : args) {
                contains = contains || input.contains(arg);
            }
            return contains;
        };
    }

    private Docket createDocket(DocketInfo info) {
        Docket docket = getDocket();
        if (info.groupName != null) {
            docket.groupName(info.groupName);
        }
        if (info.paths != null && !info.paths.isEmpty()) {
            return docket.select().paths(include(info.paths))
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)
                            .or(RequestHandlerSelectors.withClassAnnotation(RestController.class)))
                    .build();
        } else {
            return docket.select().paths(PathSelectors.any())
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)
                            .or(RequestHandlerSelectors.withClassAnnotation(RestController.class)))
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
