package com.urbondo.category.service.controller;

public class CategoryAlreadyExistException extends RuntimeException {
    public CategoryAlreadyExistException(String title) {
        super("category title:" + title + " is already exist.");
    }
}
