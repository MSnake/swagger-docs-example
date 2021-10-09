package com.msnake.swagger.docs.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Представление исключения для передачи в UI.
 */
@Getter
@Setter
@NoArgsConstructor
public class ExceptionJSONInfo {
    /**
     * Класс исключения.
     */
    private String exception;
    /**
     * Сообщение об ошибке исключения.
     */
    private String message;
    /**
     * Сокращенный стек исключения
     */
    private StackTraceElement[] stackTrace;

    /**
     * Представление исключения для передачи в UI.
     *
     * @param throwable исключение
     */
    public ExceptionJSONInfo(Throwable throwable) {
        message = throwable.toString();
        exception = throwable.getClass().getName();
        stackTrace = throwable.getStackTrace();
    }
}
