package com.urbondo.app.category.controller;

import com.urbondo.app.core.UrbondoException;

public class CategoryNotFoundException extends UrbondoException {
    public CategoryNotFoundException(String id) {
        super("Category id: " + id + " is not found.");
    }
}
