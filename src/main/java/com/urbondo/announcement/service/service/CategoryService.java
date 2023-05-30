package com.urbondo.announcement.service.service;

import com.urbondo.announcement.service.dto.AddCategoryRequestDTO;
import com.urbondo.announcement.service.dto.AddCategoryResponseDTO;
import com.urbondo.announcement.service.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO findById(String id);

    AddCategoryResponseDTO add(AddCategoryRequestDTO requestDTO);
}
