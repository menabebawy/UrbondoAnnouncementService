package com.urbondo.category.api.repository;

import java.util.Optional;

public interface CategoryRepository {
    Optional<CategoryDAO> findById(String id);

    Optional<CategoryDAO> findByTitle(String title);

    CategoryDAO save(CategoryDAO categoryDAO);
}
