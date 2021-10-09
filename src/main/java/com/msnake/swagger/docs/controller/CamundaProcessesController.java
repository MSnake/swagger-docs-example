package com.msnake.swagger.docs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для работы с "Camunda"
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/camunda")
@Api(value = "CamundaProcessesController", description = "REST-запросы для работы с \"Camunda\"")
public class CamundaProcessesController {

    @PostMapping(value = "/process/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Запустить процесс bpmn",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String startProcess(@ApiParam(value = "идентификатор процесса", example = "5faff021-0f03-4667-9aea-e6d643705437", required = true) @PathVariable String id) {
        return "process was started";
    }

}
