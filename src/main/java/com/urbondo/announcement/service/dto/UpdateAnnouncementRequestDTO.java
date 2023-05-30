package com.urbondo.announcement.service.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateAnnouncementRequestDTO(@NotBlank(message = "title must not blank") String id,
                                           @NotBlank(message = "title must not blank") String title,
                                           @NotBlank(message = "body must not blank") String body,
                                           @NotBlank(message = "categoryId must not blank") String categoryId) {}
