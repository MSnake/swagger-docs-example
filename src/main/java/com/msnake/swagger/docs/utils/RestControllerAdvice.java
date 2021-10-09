package com.msnake.swagger.docs.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Перехватчик исключений возникших в контроллерах
 */
@Slf4j
@ControllerAdvice
public class RestControllerAdvice {


    /**
     * Перехватывание исключения типа SwaggerDocsExampleException
     *
     * @param swaggerDocsExampleException исключение
     * @return структура, описывающая исключение, http-статус
     */
    @ExceptionHandler(SwaggerDocsExampleException.class)
    public ResponseEntity<ExceptionJSONInfo> handleException(SwaggerDocsExampleException swaggerDocsExampleException) {
        log.error(swaggerDocsExampleException.toString(), swaggerDocsExampleException);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionJSONInfo(swaggerDocsExampleException));
    }

    /**
     * Перехватывание исключения типа NotFoundException
     *
     * @param notFoundException исключение
     * @return структура, описывающая исключение, http-статус
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionJSONInfo> handleException(NotFoundException notFoundException) {
        log.error(notFoundException.toString(), notFoundException);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionJSONInfo(notFoundException));
    }

    /**
     * Перехватывание исключения типа Throwable
     *
     * @param throwable исключение
     * @return структура, описывающая исключение, http-статус
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ExceptionJSONInfo> handleException(Throwable throwable) {
        log.error(throwable.toString(), throwable);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionJSONInfo(throwable));
    }
}
