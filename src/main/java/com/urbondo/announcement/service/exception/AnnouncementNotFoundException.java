package com.urbondo.announcement.service.exception;

public class AnnouncementNotFoundException extends RuntimeException {
    public AnnouncementNotFoundException(String id) {
        super("announcement id: " + id + " not found.");
    }
}
