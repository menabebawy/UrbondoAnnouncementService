package com.urbondo.app.category.controller;

import com.urbondo.app.core.UrbondoException;

public class CategoryAlreadyExistException extends UrbondoException {
    public CategoryAlreadyExistException(String title) {
        super("category title:" + title + " is already exist.");
    }
}
