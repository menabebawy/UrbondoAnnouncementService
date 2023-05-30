package com.urbondo.announcement.service.controller;

import com.urbondo.announcement.service.dto.AddCategoryRequestDTO;
import com.urbondo.announcement.service.dto.AddCategoryResponseDTO;
import com.urbondo.announcement.service.dto.CategoryDTO;
import com.urbondo.announcement.service.service.CategoryService;
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
        return categoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    AddCategoryResponseDTO add(@RequestBody @Valid final AddCategoryRequestDTO requestDTO) {
        return categoryService.add(requestDTO);
    }
}
