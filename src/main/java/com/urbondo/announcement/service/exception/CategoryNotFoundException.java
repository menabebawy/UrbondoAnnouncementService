package com.urbondo.announcement.service.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String id) {
        super("category id: " + id + " not found.");
    }
}
