package com.urbondo.category.api.controller;

import com.urbondo.UrbondoException;

public class CategoryAlreadyExistException extends UrbondoException {
    public CategoryAlreadyExistException(String title) {
        super("category title:" + title + " is already exist.");
    }
}
