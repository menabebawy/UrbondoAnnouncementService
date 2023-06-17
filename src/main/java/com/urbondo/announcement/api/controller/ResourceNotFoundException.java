package com.urbondo.announcement.api.controller;

import com.urbondo.lib.UrbondoException;

public class ResourceNotFoundException extends UrbondoException {
    public ResourceNotFoundException() {
        super("");
    }
}
