package com.sanjaykumar_777.springboot_rest_webservices.exception;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException (String message) {
        super(message);
    }
}
