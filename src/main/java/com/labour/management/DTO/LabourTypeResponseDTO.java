package com.labour.management.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LabourTypeResponseDTO {
    private Long id;
    private String name;
    private CategoryResponseDTO category;
}
