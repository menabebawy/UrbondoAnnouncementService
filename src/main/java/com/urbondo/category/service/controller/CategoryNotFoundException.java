package com.urbondo.category.service.controller;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String id) {
        super("category id: " + id + " not found.");
    }
}
