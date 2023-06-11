package com.urbondo.announcement.service.dto;

import com.urbondo.announcement.service.entity.AnnouncementEntity;
import com.urbondo.category.service.repository.CategoryDAO;

public final class Mapper {
    private Mapper() {}

    public static CategoryDTO transferTo(CategoryDAO categoryDAO) {
        return new CategoryDTO(categoryDAO.getId(), categoryDAO.getTitle());
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
