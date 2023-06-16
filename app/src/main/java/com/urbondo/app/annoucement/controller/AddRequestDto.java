package com.urbondo.app.annoucement.controller;

import jakarta.validation.constraints.NotBlank;

public class AddRequestDto extends AnnouncementRequestDto {
    @NotBlank(message = "user id must not blank")
    private final String userId;

    public AddRequestDto(String title,
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
