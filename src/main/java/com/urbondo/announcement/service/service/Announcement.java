package com.urbondo.announcement.service.service;

import com.urbondo.announcement.service.repositoy.AnnouncementDAO;

public record Announcement(String id,
                           String title,
                           String body,
                           String categoryId,
                           String categoryTitle,
                           String userId) {
    public static Announcement transferBy(AnnouncementDAO announcementDAO) {
        return new Announcement(announcementDAO.getId(),
                                announcementDAO.getTitle(),
                                announcementDAO.getBody(),
                                announcementDAO.getCategoryId(),
                                announcementDAO.getCategoryTitle(),
                                announcementDAO.getUserId());
    }
}
