package com.urbondo.announcement.api.controller;

import com.urbondo.lib.ErrorResponse;
import com.urbondo.lib.UrbondoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class AnnouncementControllerAdvice {
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class, AnnouncementNotFoundException.class})
    ResponseEntity<ErrorResponse> handleControllerException(UrbondoException exception) {
        return new ResponseEntity<>(new ErrorResponse(BAD_REQUEST, exception.getMessage()), BAD_REQUEST);
    }


    @ResponseBody
    @ExceptionHandler({ResourceNotFoundException.class})
    void handleUserNotFoundException() {
        // No need to return any response body in case of resource is not existed
    }
}
