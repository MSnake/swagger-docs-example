package com.msnake.swagger.docs.utils;

public class SwaggerDocsExampleException extends RuntimeException {
    public SwaggerDocsExampleException() {
    }

    public SwaggerDocsExampleException(String message) {
        super(message);
    }

    public SwaggerDocsExampleException(String message, Throwable cause) {
        super(message, cause);
    }

    public SwaggerDocsExampleException(Throwable cause) {
        super(cause);
    }

    public SwaggerDocsExampleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
