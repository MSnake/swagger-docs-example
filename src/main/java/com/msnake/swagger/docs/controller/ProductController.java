package com.msnake.swagger.docs.controller;

import com.msnake.swagger.docs.model.request.ProductRequestDto;
import com.msnake.swagger.docs.model.response.IdResponseDto;
import com.msnake.swagger.docs.model.response.ProductResponseDto;
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
 * Контроллер для работы с сущностью "Product"
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@Api(value = "ProductController", description = "REST-запросы для работы с сущностью \"Product\"")
public class ProductController {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Создание информации о новом продукте",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IdResponseDto create(@ApiParam(value = "информация о продукте", required = true) @RequestBody ProductRequestDto data) {
        return new IdResponseDto();
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Обновление информации о продукте",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponseDto update(@ApiParam(value = "идентификатор продукта", example = "c3670811-f164-418b-980c-570aa0f32f80", required = true)
                                     @PathVariable UUID id,
                                     @ApiParam(value = "информация о продукте", required = true)
                                     @RequestBody ProductRequestDto data) {
        return new ProductResponseDto();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о продукте по идентификатору", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponseDto findById(@ApiParam(value = "идентификатор продукта", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
        return new ProductResponseDto();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации о продуктах", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponseDto> findAll() {
        return Arrays.asList(new ProductResponseDto());
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Удаление информации о продукте по идентификатору", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeById(@ApiParam(value = "идентификатор продукта", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
    }
}
