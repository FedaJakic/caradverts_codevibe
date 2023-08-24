package com.caradverts.caradverts_codevibe.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private HttpStatus status;
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(HttpStatus status) {
        this.status = status;
    }

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(HttpStatus status, List<String> messages) {
        this.status = status;
        for (String message : messages) {
            this.message += message + ", ";
        }
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
