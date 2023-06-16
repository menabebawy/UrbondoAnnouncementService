package com.urbondo.category.api.service;

import com.urbondo.category.api.repository.CategoryDao;

public interface CategoryService {
    CategoryDao findById(String id);

    CategoryDao add(String title);
}
