package com.github.repository_list.exception;

public class RepositoryHandleException extends RuntimeException {
    private String message;
    private int httpStatus;

    public RepositoryHandleException(String message) {
        super(message);
    }

    public RepositoryHandleException(String message, int httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return this.message;
    }

    public int geHttpStatus() {
        return this.httpStatus;
    }
}