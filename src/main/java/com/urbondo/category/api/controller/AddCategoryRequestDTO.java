package com.urbondo.category.api.controller;

import jakarta.validation.constraints.NotBlank;

public record AddCategoryRequestDTO(@NotBlank String title) {
}
