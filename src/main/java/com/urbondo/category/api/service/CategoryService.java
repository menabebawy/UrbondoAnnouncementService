package com.urbondo.category.api.service;

import com.urbondo.category.api.repository.CategoryDAO;

public interface CategoryService {
    CategoryDAO findById(String id);

    CategoryDAO add(String title);
}
