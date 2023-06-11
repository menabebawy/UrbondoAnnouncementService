package com.urbondo.category.service.repository;

import java.util.Optional;

public interface CategoryRepository {
    Optional<CategoryDAO> findById(String id);

    Optional<CategoryDAO> findByTitle(String title);

    String add(CategoryDAO categoryDAO);
}
