package com.msnake.swagger.docs.controller;

import com.msnake.swagger.docs.model.request.DiscountRequestDto;
import com.msnake.swagger.docs.model.response.DiscountResponseDto;
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
 * Контроллер для работы с сущностью "Discount"
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/discount")
@Api(value = "DiscountController", description = "REST-запросы для работы с сущностью \"Discount\"")
public class DiscountController {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Создание информации о новой акции",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IdResponseDto create(@ApiParam(value = "информация о продукте", required = true) @RequestBody DiscountRequestDto data) {
        return new IdResponseDto();
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Обновление информации об акции",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DiscountResponseDto update(@ApiParam(value = "идентификатор акции", example = "c3670811-f164-418b-980c-570aa0f32f80", required = true)
                                      @PathVariable UUID id,
                                      @ApiParam(value = "информация о акции", required = true)
                                      @RequestBody DiscountRequestDto data) {
        return new DiscountResponseDto();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации об акции по идентификатору", produces = MediaType.APPLICATION_JSON_VALUE)
    public DiscountResponseDto findById(@ApiParam(value = "идентификатор продукта", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
        return new DiscountResponseDto();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение информации об акциях", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DiscountResponseDto> findAll() {
        return Arrays.asList(new DiscountResponseDto());
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Удаление информации об акции по идентификатору", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeById(@ApiParam(value = "идентификатор акции", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable UUID id) {
    }
}
