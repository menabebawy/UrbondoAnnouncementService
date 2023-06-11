package com.urbondo;

import com.urbondo.announcement.service.controller.AnnouncementNotFoundException;
import com.urbondo.category.service.controller.CategoryAlreadyExistException;
import com.urbondo.category.service.controller.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class, CategoryAlreadyExistException.class})
    ResponseEntity<ErrorResponse> handleControllerException(Throwable exception) {
        return generateResponseEntity(BAD_REQUEST, exception);
    }


    @ResponseBody
    @ExceptionHandler({CategoryNotFoundException.class, AnnouncementNotFoundException.class})
    ResponseEntity<ErrorResponse> handleUserNotFoundException(Throwable exception) {
        return generateResponseEntity(NOT_FOUND, exception);
    }

    private ResponseEntity<ErrorResponse> generateResponseEntity(HttpStatus httpStatus, Throwable exception) {
        return new ResponseEntity<>(new ErrorResponse(httpStatus,
                                                      exception.getMessage(),
                                                      Arrays.toString(exception.getStackTrace())), httpStatus);
    }
}
