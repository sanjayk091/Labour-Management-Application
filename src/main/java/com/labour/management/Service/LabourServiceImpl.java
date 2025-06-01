package com.labour.management.Service;

import com.labour.management.DTO.LabourRequestDTO;
import com.labour.management.DTO.LabourResponseDTO;
import com.labour.management.Entity.CategoryEntity;
import com.labour.management.Entity.LabourEntity;
import com.labour.management.Entity.LabourTypeEntity;
import com.labour.management.Mapper.LabourMapper;
import com.labour.management.Repository.CategoryRepository;
import com.labour.management.Repository.LabourRepository;
import com.labour.management.Repository.LabourTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabourServiceImpl implements LabourService{
    private final LabourRepository labourRepository;
    private final LabourTypeRepository labourTypeRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public LabourServiceImpl(LabourRepository labourRepository, LabourTypeRepository labourTypeRepository, CategoryRepository categoryRepository) {
        this.labourRepository = labourRepository;
        this.labourTypeRepository = labourTypeRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public LabourResponseDTO saveLabour(LabourRequestDTO requestDTO) {
        CategoryEntity categoryEntity = categoryRepository.findByName(requestDTO.getLabourType().getCategory().getName())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        LabourTypeEntity labourTypeEntity = labourTypeRepository.findByName(requestDTO.getLabourType().getName())
                .orElseThrow(() -> new RuntimeException("Labour Type not found"));
        labourTypeEntity.setCategory(categoryEntity);
        LabourEntity entity = LabourMapper.toEntity(requestDTO);
        entity.setLabourType(labourTypeEntity);
        LabourEntity savedEntity = labourRepository.save(entity);
        return LabourMapper.toDTO(savedEntity);
    }

    @Override
    public LabourResponseDTO updateLabour(LabourRequestDTO requestDTO) {
        LabourEntity entity = LabourMapper.toEntity(requestDTO);
        LabourEntity savedEntity = labourRepository.save(entity);
        return LabourMapper.toDTO(savedEntity);
    }

    @Override
    public List<LabourResponseDTO> getAllLabour() {
        List<LabourEntity> entityList = labourRepository.findAll();
        return LabourMapper.toDTOList(entityList);
    }

    @Override
    public List<LabourResponseDTO> getAllAvailableLabour() {
        List<LabourEntity> entityList = labourRepository.findByIsAvailableTrue();
        return LabourMapper.toDTOList(entityList);
    }

    @Override
    public LabourResponseDTO getLabourDetails(Long id) {
        Optional<LabourEntity> entity = labourRepository.findById(id);
        return entity.map(LabourMapper::toDTO).orElse(null);
    }

    @Override
    public List<LabourResponseDTO> getAllLabourByType(String type) {
        List<LabourEntity> entityList = labourRepository.findByLabourType_Name(type);
        return LabourMapper.toDTOList(entityList);
    }

    @Override
    public List<LabourResponseDTO> getAllAvailableLabourByType(boolean isAvailable, String type) {
        List<LabourEntity> entityList = labourRepository.findByLabourType_NameAndIsAvailable(type, isAvailable);
        return LabourMapper.toDTOList(entityList);
    }

    @Override
    public void updateStatus(Long id, boolean isActive, boolean isAvailable) {
        Optional<LabourEntity> entityOptional = labourRepository.findById(id);

        if (entityOptional.isPresent()) {
            LabourEntity entity = entityOptional.get();
            entity.setActive(isActive);
            entity.setAvailable(isAvailable);
            labourRepository.save(entity);
        } else {
            throw new RuntimeException("Labour with ID " + id + " not found.");
        }
    }
}
