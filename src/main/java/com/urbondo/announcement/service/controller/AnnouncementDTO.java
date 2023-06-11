package com.urbondo.announcement.service.controller;

import com.urbondo.announcement.service.service.Announcement;

public record AnnouncementDTO(String id,
                              String title,
                              String body,
                              String categoryId,
                              String categoryTitle,
                              String userId) {
    public static AnnouncementDTO transferBy(Announcement announcement) {
        return new AnnouncementDTO(announcement.id(),
                                   announcement.title(),
                                   announcement.body(),
                                   announcement.categoryId(),
                                   announcement.categoryTitle(),
                                   announcement.userId());
    }
}
