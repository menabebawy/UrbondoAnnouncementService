package com.urbondo.category.api.service;

import com.urbondo.category.api.controller.CategoryAlreadyExistException;
import com.urbondo.category.api.controller.ResourceNotFoundException;
import com.urbondo.category.api.repository.CategoryDAO;
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
    public CategoryDAO findById(final String id) {
        Optional<CategoryDAO> categoryDAO = categoryRepository.findById(id);
        if (categoryDAO.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return categoryDAO.get();
    }

    @Override
    public CategoryDAO add(final String title) {
        if (categoryRepository.findByTitle(title).isPresent()) {
            throw new CategoryAlreadyExistException(title);
        }
        return categoryRepository.save(new CategoryDAO(UUID.randomUUID().toString(), title));
    }
}
