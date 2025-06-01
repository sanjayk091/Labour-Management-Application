package com.labour.management.Controller;

import com.labour.management.DTO.LabourRequestDTO;
import com.labour.management.DTO.LabourResponseDTO;
import com.labour.management.Service.LabourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labour")
public class LabourController {

    private final LabourService labourService;

    @Autowired
    public LabourController(LabourService labourService) {
        this.labourService = labourService;
    }

    @PostMapping
    public ResponseEntity<LabourResponseDTO> createLabour(@RequestBody LabourRequestDTO requestDTO) {
        LabourResponseDTO response = labourService.saveLabour(requestDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<LabourResponseDTO> updateLabour(@RequestBody LabourRequestDTO requestDTO) {
        LabourResponseDTO response = labourService.updateLabour(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LabourResponseDTO>> fetchAllLabour() {
        return ResponseEntity.ok(labourService.getAllLabour());
    }

    @GetMapping("/available")
    public ResponseEntity<List<LabourResponseDTO>> fetchAllAvailableLabour() {
        return ResponseEntity.ok(labourService.getAllAvailableLabour());
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<LabourResponseDTO> getLabourDetails(@PathVariable("id") Long id) {
        LabourResponseDTO response = labourService.getLabourDetails(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<LabourResponseDTO>> getAllLabourByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(labourService.getAllLabourByType(type));
    }

    @GetMapping("/type/{type}/available")
    public ResponseEntity<List<LabourResponseDTO>> getAllAvailableLabourByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(labourService.getAllAvailableLabourByType(true, type));
    }

    @PutMapping("/status")
    public ResponseEntity<String> updateStatus(@RequestParam("id") Long id,
                                               @RequestParam("isActive") boolean isActive,
                                               @RequestParam("isAvailable") boolean isAvailable) {
        labourService.updateStatus(id, isActive, isAvailable);
        return ResponseEntity.ok("Status updated.");
    }
}
