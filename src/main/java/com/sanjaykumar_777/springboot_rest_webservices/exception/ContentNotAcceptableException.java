package com.sanjaykumar_777.springboot_rest_webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ContentNotAcceptableException extends RuntimeException{
    public ContentNotAcceptableException(String message) {
        super(message);
    }
}
