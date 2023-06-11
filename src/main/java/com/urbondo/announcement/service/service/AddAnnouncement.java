package com.urbondo.announcement.service.service;

import com.urbondo.announcement.service.repositoy.AnnouncementDAO;

import java.util.UUID;

public record AddAnnouncement(String title,
                              String body,
                              String categoryId,
                              String categoryTitle,
                              String userId) {
    public AnnouncementDAO transferBy() {
        return new AnnouncementDAO(UUID.randomUUID().toString(), title, body, categoryId, categoryTitle, userId);
    }
}
