package com.urbondo.app.category.controller;

import com.urbondo.app.core.ErrorResponse;
import com.urbondo.app.core.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class, CategoryAlreadyExistException.class})
    ResponseEntity<ErrorResponse> handleControllerException(Throwable exception) {
        return new ResponseEntity<>(new ErrorResponse(BAD_REQUEST, exception.getMessage()), BAD_REQUEST);
    }


    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class})
    void handleUserNotFoundException(Throwable exception) {
        // No need to return any response body in case of resource is not existed
    }
}
