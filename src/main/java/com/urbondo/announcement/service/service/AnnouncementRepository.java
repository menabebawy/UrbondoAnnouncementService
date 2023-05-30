package com.urbondo.announcement.service.service;

import com.urbondo.announcement.service.entity.AnnouncementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends CrudRepository<AnnouncementEntity, String> {
    List<AnnouncementEntity> findAllByCategoryId(String id);
}
