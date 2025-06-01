package com.labour.management.Service;

import com.labour.management.DTO.LabourTypeRequestDTO;
import com.labour.management.DTO.LabourTypeResponseDTO;
import com.labour.management.Entity.CategoryEntity;
import com.labour.management.Entity.LabourTypeEntity;
import com.labour.management.Mapper.LabourTypeMapper;
import com.labour.management.Repository.CategoryRepository;
import com.labour.management.Repository.LabourTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabourTypeServiceImpl implements LabourTypeService{
    private final LabourTypeRepository labourTypeRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public LabourTypeServiceImpl(LabourTypeRepository labourTypeRepository,
                                 CategoryRepository categoryRepository) {
        this.labourTypeRepository = labourTypeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public LabourTypeResponseDTO save(LabourTypeRequestDTO requestDTO) {
        // Fetch the existing category from DB
        CategoryEntity category = (CategoryEntity) categoryRepository.findByName(requestDTO.getCategory().getName())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Convert DTO to Entity and assign the managed category
        LabourTypeEntity labourTypeEntity = LabourTypeMapper.toEntity(requestDTO);
        labourTypeEntity.setCategory(category);

        LabourTypeEntity savedEntity = labourTypeRepository.save(labourTypeEntity);
        return LabourTypeMapper.toDTO(savedEntity);
    }
    @Override
    public List<LabourTypeResponseDTO> getAll() {
        List<LabourTypeEntity> entityList = labourTypeRepository.findAll();
        return LabourTypeMapper.toDTOList(entityList);
    }

    @Override
    public List<LabourTypeResponseDTO> findByCategory(String category) {
        List<LabourTypeEntity> entityList = labourTypeRepository.findByCategory_Name(category);
        return LabourTypeMapper.toDTOList(entityList);
    }
}
