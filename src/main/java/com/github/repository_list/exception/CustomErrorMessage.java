package com.github.repository_list.exception;

public class CustomErrorMessage {
    private int statusCode;
    private String message;

    public CustomErrorMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}