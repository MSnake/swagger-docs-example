package com.msnake.swagger.docs.controller;

import com.msnake.swagger.docs.model.request.UserRequestDto;
import com.msnake.swagger.docs.model.response.IdResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для работы с сущностью "Contragent"
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/contragent")
@Api(value = "ContragentController", description = "REST-запросы для работы с сущностью \"Contragent\"")
public class ContragentController {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Создание информации о новом контрагенте",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IdResponseDto create(@ApiParam(value = "информация о контрагенте", required = true) @RequestBody UserRequestDto data) {
        return new IdResponseDto();
    }

}
