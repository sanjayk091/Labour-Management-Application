package com.labour.management.Controller;

import com.labour.management.DTO.CategoryRequestDTO;
import com.labour.management.DTO.CategoryResponseDTO;
import com.labour.management.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO requestDTO){
        CategoryResponseDTO response = categoryService.save(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> fetchAllCategory(){
        List<CategoryResponseDTO> responseList = categoryService.findAll();
        return ResponseEntity.ok(responseList);
    }
}
