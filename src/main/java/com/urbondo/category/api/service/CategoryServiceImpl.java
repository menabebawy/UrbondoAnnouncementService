package com.urbondo.category.api.service;

import com.urbondo.category.api.controller.CategoryAlreadyExistException;
import com.urbondo.category.api.controller.ResourceNotFoundException;
import com.urbondo.category.api.repository.CategoryDao;
import com.urbondo.category.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDao findById(String id) {
        Optional<CategoryDao> categoryDAO = categoryRepository.findById(id);
        if (categoryDAO.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return categoryDAO.get();
    }

    @Override
    public CategoryDao add(String title) {
        if (categoryRepository.findByTitle(title).isPresent()) {
            throw new CategoryAlreadyExistException(title);
        }
        return categoryRepository.save(new CategoryDao(UUID.randomUUID().toString(), title));
    }
}
