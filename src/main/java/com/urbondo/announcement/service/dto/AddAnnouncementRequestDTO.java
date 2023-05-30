package com.urbondo.announcement.service.dto;

import jakarta.validation.constraints.NotBlank;

public record AddAnnouncementRequestDTO(@NotBlank(message = "title must not blank") String title,
                                        @NotBlank(message = "body must not blank") String body,
                                        @NotBlank(message = "user must not blank") String userId,
                                        @NotBlank(message = "categoryId must not blank") String categoryId) {}
