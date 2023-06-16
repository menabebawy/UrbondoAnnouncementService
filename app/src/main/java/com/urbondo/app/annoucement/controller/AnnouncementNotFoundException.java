package com.urbondo.app.annoucement.controller;

public class AnnouncementNotFoundException extends RuntimeException {
    public AnnouncementNotFoundException(String id) {
        super("announcement id: " + id + " not found.");
    }
}
