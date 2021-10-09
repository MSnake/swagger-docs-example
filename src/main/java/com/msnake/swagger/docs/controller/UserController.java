package com.msnake.swagger.docs.controller;

import com.msnake.swagger.docs.model.request.UserRequestDto;
import com.msnake.swagger.docs.model.response.IdResponseDto;
import com.msnake.swagger.docs.model.response.UserResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Контроллер для работы с сущностью "User"
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api(value = "UserController", description = "REST-запросы для работы с сущностью \"User\"")
public class UserController {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Создание информации о новом пользователе",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IdResponseDto create(@ApiParam(value = "информация о пользователе", required = true) @RequestBody UserRequestDto data) {
        return new IdResponseDto();
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Обновление информации о пользователе",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto update(@ApiParam(value = "идентификатор пользователя", example = "c3670811-f164-418b-980c-570aa0f32f80", required = true)
                                  @PathVariable UUID id,
                                  @ApiParam(value = "информация о пользователе", required = true)
                                  @RequestBody UserRequestDto data) {
        return new UserResponseDto();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о пользователе по идентификатору", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto findById(@ApiParam(value = "идентификатор пользователя", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
        return new UserResponseDto();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о пользователях", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponseDto> findAll() {
        return Arrays.asList(new UserResponseDto());
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Удаление информации о пользователе по идентификатору", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeById(@ApiParam(value = "идентификатор пользователя", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
    }
}
