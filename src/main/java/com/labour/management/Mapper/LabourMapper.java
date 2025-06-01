package com.labour.management.Mapper;

import com.labour.management.DTO.LabourRequestDTO;
import com.labour.management.DTO.LabourResponseDTO;
import com.labour.management.Entity.LabourEntity;

import java.util.List;
import java.util.stream.Collectors;

public class LabourMapper {
    public static LabourEntity toEntity(LabourRequestDTO requestDTO){
        LabourEntity entity = new LabourEntity();
        entity.setName(requestDTO.getName());
        entity.setContactNumber(requestDTO.getContactNumber());
        entity.setActive(requestDTO.isActive());
        entity.setAvailable(requestDTO.isAvailable());
        entity.setLabourType(LabourTypeMapper.toEntity(requestDTO.getLabourType()));
        entity.setCharges(requestDTO.getCharges());
        return entity;
    }

    public static LabourResponseDTO toDTO(LabourEntity entity){
        LabourResponseDTO responseDTO = new LabourResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setName(entity.getName());
        responseDTO.setContactNumber(entity.getContactNumber());
        responseDTO.setCharges(entity.getCharges());
        responseDTO.setAvailable(entity.isAvailable());
        responseDTO.setActive(entity.isActive());
        responseDTO.setLabourType(LabourTypeMapper.toDTO(entity.getLabourType()));
        return responseDTO;
    }

    public static List<LabourResponseDTO> toDTOList(List<LabourEntity> entityList){
        return entityList.stream()
                .map(LabourMapper::toDTO)
                .collect(Collectors.toList());
    }
}
