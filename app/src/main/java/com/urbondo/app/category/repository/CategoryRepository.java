package com.urbondo.app.category.repository;

import com.urbondo.app.core.UrbondoRepository;

import java.util.Optional;

public interface CategoryRepository extends UrbondoRepository<CategoryDao> {
    Optional<CategoryDao> findByTitle(String title);
}
