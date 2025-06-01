package com.labour.management.Controller;

import com.labour.management.DTO.LabourTypeRequestDTO;
import com.labour.management.DTO.LabourTypeResponseDTO;
import com.labour.management.Service.LabourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/labour-type")
public class LabourTypeController {

    private final LabourTypeService labourTypeService;
    @Autowired
    public LabourTypeController(LabourTypeService labourTypeService) {
        this.labourTypeService = labourTypeService;
    }

    @PostMapping
    public ResponseEntity<LabourTypeResponseDTO> createLabourType(@RequestBody LabourTypeRequestDTO requestDTO){
        LabourTypeResponseDTO response = labourTypeService.save(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LabourTypeResponseDTO>> fetchAllLabourType(){
        List<LabourTypeResponseDTO> responseList = labourTypeService.getAll();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<LabourTypeResponseDTO>> fetchAllLabourByCategory (@PathVariable("categoryName") String categoryName){
        List<LabourTypeResponseDTO> responseList = labourTypeService.findByCategory(categoryName);
        return ResponseEntity.ok(responseList);
    }
}
