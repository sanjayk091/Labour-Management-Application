package com.labour.management.Service;

import com.labour.management.DTO.CategoryRequestDTO;
import com.labour.management.DTO.CategoryResponseDTO;
import com.labour.management.Entity.CategoryEntity;
import com.labour.management.Mapper.CategoryMapper;
import com.labour.management.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDTO save(CategoryRequestDTO requestDTO) {
        CategoryEntity entity = CategoryMapper.toEntity(requestDTO);
        CategoryEntity savedEntity = categoryRepository.save(entity);
        return CategoryMapper.toDTO(savedEntity);
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return CategoryMapper.toDTOList(categoryEntities);
    }
}
