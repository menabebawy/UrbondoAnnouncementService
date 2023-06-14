package com.urbondo.announcement.api.repositoy;

import java.util.Optional;

public interface AnnouncementRepository {
    Optional<AnnouncementDAO> findById(String id);

    AnnouncementDAO save(AnnouncementDAO announcementDAO);

    void delete(AnnouncementDAO announcementDAO);
}
