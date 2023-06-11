package com.urbondo.announcement.service.repositoy;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnouncementRepository {
    Optional<AnnouncementDAO> findById(String id);

    String add(AnnouncementDAO announcementDAO);

    AnnouncementDAO update(AnnouncementDAO announcementDAO);

    void delete(AnnouncementDAO announcementDAO);
}
