package com.urbondo.category.api.repository;

import com.urbondo.core.UrbondoRepository;

import java.util.Optional;

public interface CategoryRepository extends UrbondoRepository<CategoryDao> {
    Optional<CategoryDao> findByTitle(String title);
}
