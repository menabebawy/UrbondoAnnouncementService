package com.urbondo.category.api.controller;

import jakarta.validation.constraints.NotBlank;

record AddRequestDTO(@NotBlank String title) {
}
