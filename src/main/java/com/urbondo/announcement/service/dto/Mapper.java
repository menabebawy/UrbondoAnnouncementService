package com.urbondo.announcement.service.dto;

import com.urbondo.announcement.service.entity.CategoryEntity;

public final class Mapper {
    public static CategoryDTO transferTo(CategoryEntity categoryEntity) {
        return new CategoryDTO(categoryEntity.getId(), categoryEntity.getTitle());
    }

    public static CategoryEntity transferTo(CategoryDTO categoryDTO) {
        return new CategoryEntity(categoryDTO.id(), categoryDTO.title());
    }
}
