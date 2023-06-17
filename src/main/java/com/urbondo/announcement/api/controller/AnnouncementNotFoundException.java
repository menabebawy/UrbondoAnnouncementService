package com.urbondo.announcement.api.controller;

public class AnnouncementNotFoundException extends RuntimeException {
    public AnnouncementNotFoundException(String id) {
        super("announcement id: " + id + " not found.");
    }
}
