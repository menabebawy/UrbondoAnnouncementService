package com.urbondo.announcement.api.controller;

import jakarta.validation.constraints.NotBlank;

public class UpdateRequestDTO extends AnnouncementRequestDTO {
    @NotBlank(message = "id must not blank")
    private final String id;

    public UpdateRequestDTO(String id, String title, String body, String categoryId) {
        super(title, body, categoryId);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
