package com.urbondo.announcement.service.controller;

import com.urbondo.announcement.service.exception.CategoryAlreadyExistException;
import com.urbondo.announcement.service.exception.CategoryNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class AnnouncementControllerAdvice {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    String handleUserNotFoundException(CategoryNotFoundException exception) {
        return createResponseBody(exception.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({CategoryAlreadyExistException.class})
    String handleBadRequestException(Exception exception) {
        return createResponseBody(exception.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    String handleValidationErrors(MethodArgumentNotValidException exception) {
        String defaultMessage = "";
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            defaultMessage = fieldError.getDefaultMessage();
        }
        return createResponseBody(defaultMessage);
    }

    private String createResponseBody(String value) {
        return String.format("{ \"message\": \"%s\" }", value);
    }
}
