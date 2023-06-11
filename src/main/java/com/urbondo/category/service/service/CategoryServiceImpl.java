package com.urbondo.category.service.service;

import com.urbondo.category.service.controller.CategoryAlreadyExistException;
import com.urbondo.category.service.controller.CategoryNotFoundException;
import com.urbondo.category.service.repository.CategoryDAO;
import com.urbondo.category.service.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(final String id) {
        Optional<CategoryDAO> categoryDAO = categoryRepository.findById(id);
        if (categoryDAO.isEmpty()) {
            throw new CategoryNotFoundException(id);
        }
        return new Category(categoryDAO.get().getId(), categoryDAO.get().getTitle());
    }

    @Override
    public String add(final String title) {
        if (categoryRepository.findByTitle(title).isPresent()) {
            throw new CategoryAlreadyExistException(title);
        }
        return categoryRepository.add(new CategoryDAO(UUID.randomUUID().toString(), title));
    }
}
