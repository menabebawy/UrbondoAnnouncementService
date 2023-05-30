package com.urbondo.announcement.service.dto;

import com.urbondo.announcement.service.entity.CategoryEntity;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record AddCategoryRequestDTO(@NotBlank String title) {
    public CategoryEntity transferTo() {
        return new CategoryEntity(UUID.randomUUID().toString(), title);
    }
}
