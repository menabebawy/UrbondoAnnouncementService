package com.urbondo.category.service.controller;

import com.urbondo.category.service.service.Category;
import com.urbondo.category.service.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    CategoryDTO fetchById(@PathVariable @Valid final String id) {
        Category category = categoryService.findById(id);
        return new CategoryDTO(category.id(), category.title());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    AddCategoryResponseDTO add(@RequestBody @Valid final AddCategoryRequestDTO requestDTO) {
        return new AddCategoryResponseDTO(categoryService.add(requestDTO.title()));
    }
}
