package com.urbondo.announcement.service.service;

import com.urbondo.announcement.service.dto.AddCategoryRequestDTO;
import com.urbondo.announcement.service.dto.AddCategoryResponseDTO;
import com.urbondo.announcement.service.dto.CategoryDTO;
import com.urbondo.announcement.service.dto.Mapper;
import com.urbondo.announcement.service.entity.CategoryEntity;
import com.urbondo.announcement.service.exception.CategoryAlreadyExistException;
import com.urbondo.announcement.service.exception.CategoryNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO findById(String id) {
        return categoryRepository.findById(id)
                .map(Mapper::transferTo)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public AddCategoryResponseDTO add(AddCategoryRequestDTO requestDTO) {
        if (categoryRepository.findByTitle(requestDTO.title()) != null) {
            throw new CategoryAlreadyExistException(requestDTO.title());
        }

        CategoryEntity categoryEntity = categoryRepository.save(requestDTO.transferTo());
        return new AddCategoryResponseDTO(categoryEntity.getId());
    }
}
