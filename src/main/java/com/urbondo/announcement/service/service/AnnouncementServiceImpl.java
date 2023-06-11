package com.urbondo.announcement.service.service;

import com.urbondo.announcement.service.controller.AnnouncementNotFoundException;
import com.urbondo.announcement.service.repositoy.AnnouncementDAO;
import com.urbondo.announcement.service.repositoy.AnnouncementRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public Announcement findById(String id) {
        return Announcement.transferBy(findByIdOrThrowException(id));
    }

    @Override
    public String add(AddAnnouncement addAnnouncement) {
        return announcementRepository.add(addAnnouncement.transferBy());
    }

    @Override
    public Announcement update(UpdateAnnouncement updateAnnouncement) {
        AnnouncementDAO storedAnnouncementDao = findByIdOrThrowException(updateAnnouncement.id());
        storedAnnouncementDao.setTitle(updateAnnouncement.title());
        storedAnnouncementDao.setBody(updateAnnouncement.body());
        storedAnnouncementDao.setCategoryId(updateAnnouncement.categoryId());
        storedAnnouncementDao.setCategoryTitle(updateAnnouncement.categoryTitle());
        announcementRepository.update(storedAnnouncementDao);
        return Announcement.transferBy(storedAnnouncementDao);
    }

    private AnnouncementDAO findByIdOrThrowException(String id) {
        Optional<AnnouncementDAO> announcementDAO = announcementRepository.findById(id);

        if (announcementDAO.isEmpty()) {
            throw new AnnouncementNotFoundException(id);
        }

        return announcementDAO.get();
    }

    @Override
    public void deleteById(final String id) {
        announcementRepository.delete(findByIdOrThrowException(id));
    }
}
