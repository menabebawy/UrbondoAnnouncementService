package com.urbondo.app.category.controller;

import jakarta.validation.constraints.NotBlank;

public record AddCategoryRequestDto(@NotBlank String title) {
}
