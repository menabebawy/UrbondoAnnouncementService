package com.urbondo.category.api.controller;

import com.urbondo.lib.UrbondoException;

public class CategoryNotFoundException extends UrbondoException {
    public CategoryNotFoundException(String id) {
        super("Category id: " + id + " is not found.");
    }
}
