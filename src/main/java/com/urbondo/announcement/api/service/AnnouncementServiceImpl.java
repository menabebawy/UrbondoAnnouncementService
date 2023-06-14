package com.urbondo.announcement.api.service;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.urbondo.announcement.api.controller.AddRequestDTO;
import com.urbondo.announcement.api.controller.AnnouncementDTO;
import com.urbondo.announcement.api.controller.AnnouncementNotFoundException;
import com.urbondo.announcement.api.controller.UpdateRequestDTO;
import com.urbondo.announcement.api.repositoy.AnnouncementDAO;
import com.urbondo.announcement.api.repositoy.AnnouncementRepository;
import com.urbondo.category.api.controller.CategoryNotFoundException;
import com.urbondo.category.api.repository.CategoryDAO;
import com.urbondo.category.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    AnnouncementServiceImpl(AnnouncementRepository announcementRepository, CategoryRepository categoryRepository) {
        this.announcementRepository = announcementRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public AnnouncementDTO findById(String id) {
        Optional<AnnouncementDAO> announcementDAO = announcementRepository.findById(id);

        if (announcementDAO.isEmpty()) {
            throw new ResourceNotFoundException(id);
        }

        return announcementDAO.get().transferTo();
    }

    @Override
    public AnnouncementDTO add(AddRequestDTO requestDTO) {
        CategoryDAO categoryDAO = getCategoryDaoOrThrowException(requestDTO.getCategoryId());

        AnnouncementDAO announcementDAO = new AnnouncementDAO(UUID.randomUUID().toString(),
                                                              requestDTO.getTitle(),
                                                              requestDTO.getBody(),
                                                              requestDTO.getCategoryId(),
                                                              categoryDAO.getTitle(),
                                                              requestDTO.getUserId());
        return announcementRepository.save(announcementDAO).transferTo();
    }

    private CategoryDAO getCategoryDaoOrThrowException(String id) {
        Optional<CategoryDAO> categoryDAO = categoryRepository.findById(id);

        if (categoryDAO.isEmpty()) {
            throw new CategoryNotFoundException(id);
        }
        return categoryDAO.get();
    }

    @Override
    public AnnouncementDTO update(UpdateRequestDTO requestDTO) {
        AnnouncementDAO storedAnnouncementDao = findByIdOrThrowException(requestDTO.getId());
        CategoryDAO categoryDAO = getCategoryDaoOrThrowException(requestDTO.getCategoryId());

        storedAnnouncementDao.setTitle(requestDTO.getTitle());
        storedAnnouncementDao.setBody(requestDTO.getBody());
        storedAnnouncementDao.setCategoryId(requestDTO.getCategoryId());
        storedAnnouncementDao.setCategoryTitle(categoryDAO.getTitle());

        announcementRepository.save(storedAnnouncementDao);

        return storedAnnouncementDao.transferTo();
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
