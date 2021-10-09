package com.msnake.swagger.docs.controller;

import com.msnake.swagger.docs.model.request.BasketRequestDto;
import com.msnake.swagger.docs.model.response.BasketResponseDto;
import com.msnake.swagger.docs.model.response.IdResponseDto;
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
 * Контроллер для работы с сущностью "Basket"
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
@Api(value = "BasketController", description = "REST-запросы для работы с сущностью \"Basket\"")
public class BasketController {


    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Создание информации о новой корзине",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IdResponseDto create(@ApiParam(value = "информация о добавляемом продукте в корзину", required = true) @RequestBody BasketRequestDto data) {
        return new IdResponseDto();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о записи в корзине покупок", produces = MediaType.APPLICATION_JSON_VALUE)
    public BasketResponseDto findById(@ApiParam(value = "идентификатор корзины", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
        return new BasketResponseDto();
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о корзинах заданного пользователя", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BasketResponseDto> findByUserId(@ApiParam(value = "идентификатор пользователя", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
        return Arrays.asList(new BasketResponseDto());
    }

    @GetMapping(value = "/session/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о корзине заданной сессии", produces = MediaType.APPLICATION_JSON_VALUE)
    public BasketResponseDto findBySession(@ApiParam(value = "идентификатор сессии", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable String sessionId) {
        return new BasketResponseDto();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о корзинах", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BasketResponseDto> findAll() {
        return Arrays.asList(new BasketResponseDto());
    }

    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Пересчитать стоимость товаров в корзине", produces = MediaType.APPLICATION_JSON_VALUE)
    public BasketResponseDto recalculate(@ApiParam(value = "идентификатор корзины", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
        return new BasketResponseDto();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Удаление информации о корзине", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeById(@ApiParam(value = "идентификатор корзины", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
    }
}
