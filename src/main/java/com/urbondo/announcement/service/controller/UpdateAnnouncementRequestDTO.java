package com.urbondo.announcement.service.controller;

import com.urbondo.announcement.service.service.UpdateAnnouncement;
import jakarta.validation.constraints.NotBlank;

public record UpdateAnnouncementRequestDTO(@NotBlank(message = "title must not blank") String id,
                                           @NotBlank(message = "title must not blank") String title,
                                           @NotBlank(message = "body must not blank") String body,
                                           @NotBlank(message = "categoryId must not blank") String categoryId,
                                           @NotBlank(message = "categoryTitle must not blank") String categoryTitle) {
    public UpdateAnnouncement transferTo() {
        return new UpdateAnnouncement(id, title, body, categoryId, categoryTitle);
    }
}
