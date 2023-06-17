package com.urbondo.category.api.controller;

import jakarta.validation.constraints.NotBlank;

public record AddCategoryRequestDto(@NotBlank String title) {
}
