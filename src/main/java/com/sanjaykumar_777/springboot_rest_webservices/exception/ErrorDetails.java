package com.sanjaykumar_777.springboot_rest_webservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String errorDetails;

    public ErrorDetails(LocalDateTime timeStamp, String message, String errorDetails) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }
}
