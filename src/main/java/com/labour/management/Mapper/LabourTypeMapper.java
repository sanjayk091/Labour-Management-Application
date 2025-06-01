package com.labour.management.Mapper;

import com.labour.management.DTO.LabourTypeRequestDTO;
import com.labour.management.DTO.LabourTypeResponseDTO;
import com.labour.management.Entity.LabourTypeEntity;

import java.util.List;
import java.util.stream.Collectors;

public class LabourTypeMapper {

    public static LabourTypeEntity toEntity(LabourTypeRequestDTO requestDTO){
        LabourTypeEntity entity = new LabourTypeEntity();
        entity.setName(requestDTO.getName());
        entity.setCategory(CategoryMapper.toEntity(requestDTO.getCategory()));
        return entity;
    }

    public static LabourTypeResponseDTO toDTO(LabourTypeEntity entity){
        LabourTypeResponseDTO responseDTO = new LabourTypeResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setName(entity.getName());
        responseDTO.setCategory(CategoryMapper.toDTO(entity.getCategory()));
        return responseDTO;
    }

    public static List<LabourTypeResponseDTO> toDTOList(List<LabourTypeEntity> entityList){
        return entityList.stream()
                .map(LabourTypeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
