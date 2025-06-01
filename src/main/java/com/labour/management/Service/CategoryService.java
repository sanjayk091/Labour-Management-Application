package com.labour.management.Service;

import com.labour.management.DTO.CategoryRequestDTO;
import com.labour.management.DTO.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO save(CategoryRequestDTO requestDTO);
    List<CategoryResponseDTO> findAll();
}
