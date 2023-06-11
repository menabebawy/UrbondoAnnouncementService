package com.urbondo.category.service.service;

public interface CategoryService {
    Category findById(String id);

    String add(String title);
}
