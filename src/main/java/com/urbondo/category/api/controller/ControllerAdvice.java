package com.urbondo.category.api.controller;

import com.urbondo.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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


    @ResponseBody
    @ExceptionHandler({ResourceNotFoundException.class})
    ResponseEntity<ErrorResponse> handleUserNotFoundException(Throwable exception) {
        return new ResponseEntity<>(new ErrorResponse(NOT_FOUND, exception.getMessage()), NOT_FOUND);
    }
}
