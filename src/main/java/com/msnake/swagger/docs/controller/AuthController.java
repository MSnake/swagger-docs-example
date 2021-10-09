package com.msnake.swagger.docs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для работы с Авторизацией
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Api(value = "AuthController", description = "REST-запросы для работы с авторизацией")
public class AuthController {

    @GetMapping(value = "/token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получить токен авторизации",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAuthToken() {
        return "Auth token";
    }

}
