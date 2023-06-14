package com.urbondo.announcement.api.controller;

public class AnnouncementDTO extends UpdateRequestDTO {
    private final String userId;
    private final String categoryTitle;

    public AnnouncementDTO(String id,
                           String title,
                           String body,
                           String categoryId,
                           String categoryTitle,
                           String userId) {
        super(id, title, body, categoryId);
        this.userId = userId;
        this.categoryTitle = categoryTitle;
    }

    public String getUserId() {
        return userId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }
}
