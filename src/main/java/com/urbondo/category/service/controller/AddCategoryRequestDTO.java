package com.urbondo.category.service.controller;

import jakarta.validation.constraints.NotBlank;

record AddCategoryRequestDTO(@NotBlank String title) {}
