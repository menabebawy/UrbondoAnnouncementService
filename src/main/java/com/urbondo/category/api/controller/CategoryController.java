package com.urbondo.category.api.controller;

import com.urbondo.category.api.repository.CategoryDAO;
import com.urbondo.category.api.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    CategoryDAO fetchById(@PathVariable @Valid String id) {
        return categoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    CategoryDAO add(@RequestBody @Valid AddCategoryRequestDTO requestDTO) {
        return categoryService.add(requestDTO.title());
    }
}
