package com.urbondo.announcement.service.service;

import com.urbondo.announcement.service.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, String> {
    CategoryEntity findByTitle(String title);
}
