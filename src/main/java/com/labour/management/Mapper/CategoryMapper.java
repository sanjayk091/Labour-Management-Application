package com.labour.management.Mapper;

import com.labour.management.DTO.CategoryRequestDTO;
import com.labour.management.DTO.CategoryResponseDTO;
import com.labour.management.Entity.CategoryEntity;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryEntity toEntity(CategoryRequestDTO requestDTO) {
        if (requestDTO == null) return null;

        CategoryEntity entity = new CategoryEntity();
        entity.setName(requestDTO.getName());
        return entity;
    }

    public static CategoryResponseDTO toDTO(CategoryEntity entity) {
        if (entity == null) return null;

        CategoryResponseDTO responseDTO = new CategoryResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setName(entity.getName());
        return responseDTO;
    }

    public static List<CategoryResponseDTO> toDTOList(List<CategoryEntity> entities) {
        return entities.stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}

