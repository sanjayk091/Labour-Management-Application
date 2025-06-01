package com.labour.management.Service;

import com.labour.management.DTO.LabourTypeRequestDTO;
import com.labour.management.DTO.LabourTypeResponseDTO;

import java.util.List;

public interface LabourTypeService {
    LabourTypeResponseDTO save(LabourTypeRequestDTO requestDTO);
    List<LabourTypeResponseDTO> getAll();
    List<LabourTypeResponseDTO> findByCategory(String category);

}
