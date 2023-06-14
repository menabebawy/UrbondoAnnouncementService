package com.urbondo.announcement.api.controller;

import jakarta.validation.constraints.NotBlank;

public abstract class AnnouncementRequestDTO {
    @NotBlank(message = "title must not blank")
    protected final String title;

    @NotBlank(message = "body must not blank")
    protected final String body;

    @NotBlank(message = "category id must not blank")
    protected final String categoryId;

    protected AnnouncementRequestDTO(String title, String body, String categoryId) {
        this.title = title;
        this.body = body;
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
