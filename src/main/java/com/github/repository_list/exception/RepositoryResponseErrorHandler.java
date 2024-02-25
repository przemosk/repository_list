package com.github.repository_list.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class RepositoryResponseErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorMessage> handleException(Exception exception,
            WebRequest request,
            HttpServletResponse httpServletResponse) {
        CustomErrorMessage exceptionResponse = new CustomErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<CustomErrorMessage> handleForbiddenException(Exception ex, WebRequest request) {
        CustomErrorMessage exceptionResponse = new CustomErrorMessage(HttpStatus.FORBIDDEN.value(), ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(RepositoryHandleException.class)
    public ResponseEntity<CustomErrorMessage> handleRepositoryException(
            RepositoryHandleException repositoryHandleException,
            WebRequest request) {
        CustomErrorMessage exceptionResponse = new CustomErrorMessage(repositoryHandleException.geHttpStatus(),
                repositoryHandleException.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
