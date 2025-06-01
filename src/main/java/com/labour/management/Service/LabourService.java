package com.labour.management.Service;

import com.labour.management.DTO.LabourRequestDTO;
import com.labour.management.DTO.LabourResponseDTO;

import java.util.List;

public interface LabourService {
    LabourResponseDTO saveLabour(LabourRequestDTO requestDTO);
    LabourResponseDTO updateLabour(LabourRequestDTO requestDTO);
    List<LabourResponseDTO> getAllLabour();
    List<LabourResponseDTO> getAllAvailableLabour();
    LabourResponseDTO getLabourDetails(Long id);
    List<LabourResponseDTO> getAllLabourByType(String type);
    List<LabourResponseDTO> getAllAvailableLabourByType(boolean isAvailable, String type);
    void updateStatus(Long id, boolean isActive, boolean isAvailable);
}
