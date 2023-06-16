package com.urbondo.app.category.service;

import com.urbondo.app.category.repository.CategoryDao;

public interface CategoryService {
    CategoryDao findById(String id);

    CategoryDao add(String title);
}
