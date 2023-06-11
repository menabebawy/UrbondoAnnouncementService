package com.urbondo.announcement.service.service;

public interface AnnouncementService {
    Announcement findById(String id);

    String add(AddAnnouncement addAnnouncement);

    Announcement update(UpdateAnnouncement updateAnnouncement);

    void deleteById(String id);
}
