package com.urbondo.announcement.service.controller;

import com.urbondo.announcement.service.service.AddAnnouncement;
import jakarta.validation.constraints.NotBlank;

record AddAnnouncementRequestDTO(@NotBlank(message = "title must not blank") String title,
                                 @NotBlank(message = "body must not blank") String body,
                                 @NotBlank(message = "categoryId must not blank") String categoryId,
                                 @NotBlank(message = "categoryTitle must not blank") String categoryTitle,
                                 @NotBlank(message = "user must not blank") String userId) {
    public AddAnnouncement transferTo() {
        return new AddAnnouncement(title, body, categoryId, categoryTitle, userId);
    }
}
