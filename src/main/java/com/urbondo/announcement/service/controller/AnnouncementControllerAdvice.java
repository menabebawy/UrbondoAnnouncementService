package com.urbondo.announcement.service.controller;

import com.urbondo.announcement.service.exception.CategoryAlreadyExistException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class AnnouncementControllerAdvice {
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({CategoryAlreadyExistException.class})
    String handleBadRequestException(Exception exception) {
        return createResponseBody(exception.getMessage());
    }

    private String createResponseBody(String value) {
        return String.format("{ \"message\": \"%s\" }", value);
    }
}
