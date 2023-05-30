package com.urbondo.announcement.service.exception;

public class CategoryAlreadyExistException extends RuntimeException {
    public CategoryAlreadyExistException(String title) {
        super("category title:" + title + " is already exist.");
    }
}
