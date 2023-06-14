package com.urbondo.announcement.api.controller;

import jakarta.validation.constraints.NotBlank;

public class AddRequestDTO extends AnnouncementRequestDTO {
    @NotBlank(message = "user id must not blank")
    private final String userId;

    public AddRequestDTO(String title,
                         String body,
                         String categoryId,
                         String userId) {
        super(title, body, categoryId);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
