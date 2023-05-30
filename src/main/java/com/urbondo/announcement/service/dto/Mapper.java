package com.urbondo.announcement.service.dto;

import com.urbondo.announcement.service.entity.AnnouncementEntity;
import com.urbondo.announcement.service.entity.CategoryEntity;

public final class Mapper {
    private Mapper() {}

    public static CategoryDTO transferTo(CategoryEntity categoryEntity) {
        return new CategoryDTO(categoryEntity.getId(), categoryEntity.getTitle());
    }

    public static AnnouncementDTO transferTo(AnnouncementEntity announcementEntity) {
        return new AnnouncementDTO(announcementEntity.getId(),
                                   announcementEntity.getTitle(),
                                   announcementEntity.getBody(),
                                   announcementEntity.getCategoryId(),
                                   announcementEntity.getTitle(),
                                   announcementEntity.getUserId());
    }

    public static AnnouncementEntity transferTo(AnnouncementDTO announcementDTO) {
        return new AnnouncementEntity(announcementDTO.id(),
                                      announcementDTO.title(),
                                      announcementDTO.body(),
                                      announcementDTO.categoryId(),
                                      announcementDTO.categoryTitle(),
                                      announcementDTO.userId());
    }
}
