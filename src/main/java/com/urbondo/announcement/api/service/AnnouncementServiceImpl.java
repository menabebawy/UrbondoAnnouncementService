package com.urbondo.announcement.api.service;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.urbondo.announcement.api.controller.AddRequestDto;
import com.urbondo.announcement.api.controller.AnnouncementNotFoundException;
import com.urbondo.announcement.api.controller.UpdateRequestDto;
import com.urbondo.announcement.api.repositoy.AnnouncementDao;
import com.urbondo.category.api.controller.CategoryNotFoundException;
import com.urbondo.category.api.repository.CategoryDao;
import com.urbondo.category.api.repository.CategoryRepository;
import com.urbondo.lib.UrbondoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
class AnnouncementServiceImpl implements AnnouncementService {
    private final UrbondoRepository<AnnouncementDao> announcementRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    AnnouncementServiceImpl(UrbondoRepository<AnnouncementDao> announcementRepository, CategoryRepository categoryRepository) {
        this.announcementRepository = announcementRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public AnnouncementDao findById(String id) {
        Optional<AnnouncementDao> announcementDAO = announcementRepository.findById(id);

        if (announcementDAO.isEmpty()) {
            throw new ResourceNotFoundException(id);
        }

        return announcementDAO.get();
    }

    @Override
    public AnnouncementDao add(AddRequestDto requestDTO) {
        CategoryDao categoryDAO = getCategoryDaoOrThrowException(requestDTO.getCategoryId());

        AnnouncementDao announcementDAO = new AnnouncementDao(UUID.randomUUID().toString(),
                requestDTO.getTitle(),
                requestDTO.getBody(),
                requestDTO.getCategoryId(),
                categoryDAO.getTitle(),
                requestDTO.getUserId());
        return announcementRepository.save(announcementDAO);
    }

    private CategoryDao getCategoryDaoOrThrowException(String id) {
        Optional<CategoryDao> categoryDAO = categoryRepository.findById(id);

        if (categoryDAO.isEmpty()) {
            throw new CategoryNotFoundException(id);
        }
        return categoryDAO.get();
    }

    @Override
    public AnnouncementDao update(UpdateRequestDto requestDTO) {
        AnnouncementDao storedAnnouncementDao = findByIdOrThrowException(requestDTO.getId());
        CategoryDao categoryDAO = getCategoryDaoOrThrowException(requestDTO.getCategoryId());

        storedAnnouncementDao.setTitle(requestDTO.getTitle());
        storedAnnouncementDao.setBody(requestDTO.getBody());
        storedAnnouncementDao.setCategoryId(requestDTO.getCategoryId());
        storedAnnouncementDao.setCategoryTitle(categoryDAO.getTitle());

        announcementRepository.save(storedAnnouncementDao);

        return storedAnnouncementDao;
    }

    private AnnouncementDao findByIdOrThrowException(String id) {
        Optional<AnnouncementDao> announcementDAO = announcementRepository.findById(id);

        if (announcementDAO.isEmpty()) {
            throw new AnnouncementNotFoundException(id);
        }

        return announcementDAO.get();
    }

    @Override
    public void deleteById(String id) {
        announcementRepository.delete(findByIdOrThrowException(id));
    }
}
