package com.msnake.swagger.docs.controller;

import com.msnake.swagger.docs.model.request.ShoppingCartRequestDto;
import com.msnake.swagger.docs.model.response.IdResponseDto;
import com.msnake.swagger.docs.model.response.ShoppingCartResponseDto;
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
 * Контроллер для работы с сущностью "ShoppingCart"
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping/cart")
@Api(value = "ShoppingCart", description = "REST-запросы для работы с сущностью \"ShoppingCart\"")
public class ShoppingCartController {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Создание информации о новой записи в корзине покупок",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IdResponseDto create(@ApiParam(value = "информация о добавляемом продукте в корзину", required = true) @RequestBody ShoppingCartRequestDto data) {
        return new IdResponseDto();
    }

    @PostMapping(value = "/list/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Создание информации о новых записях в корзине покупок",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShoppingCartResponseDto> createList(@ApiParam(value = "информация о добавляемых продуктах в корзину", required = true) @RequestBody List<ShoppingCartRequestDto> requestDtos) {
        return Arrays.asList(new ShoppingCartResponseDto());
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Обновление информации о записи в корзине покупок",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCartResponseDto update(@ApiParam(value = "идентификатор корзины покупок", example = "c3670811-f164-418b-980c-570aa0f32f80", required = true)
                                          @PathVariable UUID id,
                                          @ApiParam(value = "информация о записи в корзине покупок", required = true)
                                          @RequestBody ShoppingCartRequestDto data) {
        return new ShoppingCartResponseDto();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о записи в корзине покупок", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCartResponseDto findById(@ApiParam(value = "идентификатор записи в корзине покупок", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
        return new ShoppingCartResponseDto();
    }

    @GetMapping(value = "/basket/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о записях в корзине покупок", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShoppingCartResponseDto> findByBasketId(@ApiParam(value = "идентификатор корзины", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
        return Arrays.asList(new ShoppingCartResponseDto());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о записях в корзине покупок", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShoppingCartResponseDto> findAll() {
        return Arrays.asList(new ShoppingCartResponseDto());
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Удаление информации о записи в корзине покупок", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeById(@ApiParam(value = "идентификатор записи в корзине покупок", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
    }
}
