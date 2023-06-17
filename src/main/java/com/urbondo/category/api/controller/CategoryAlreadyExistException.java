package com.urbondo.category.api.controller;

import com.urbondo.lib.UrbondoException;

public class CategoryAlreadyExistException extends UrbondoException {
    public CategoryAlreadyExistException(String title) {
        super("category title:" + title + " is already exist.");
    }
}
