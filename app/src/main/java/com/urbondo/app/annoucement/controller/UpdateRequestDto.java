package com.urbondo.app.annoucement.controller;

import jakarta.validation.constraints.NotBlank;

public class UpdateRequestDto extends AnnouncementRequestDto {
    @NotBlank(message = "id must not blank")
    private final String id;

    public UpdateRequestDto(String id, String title, String body, String categoryId) {
        super(title, body, categoryId);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
