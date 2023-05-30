package com.urbondo.announcement.service.dto;

import com.urbondo.announcement.service.entity.AnnouncementEntity;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record AddAnnouncementRequestDTO(@NotBlank(message = "title must not blank") String title,
                                        @NotBlank(message = "body must not blank") String body,
                                        @NotBlank(message = "user must not blank") String userId,
                                        @NotBlank(message = "categoryId must not blank") String categoryId) {

    public AnnouncementEntity transferTo(String categoryTitle) {
        return new AnnouncementEntity(UUID.randomUUID().toString(), title, body, categoryId, categoryTitle, userId);
    }
}
