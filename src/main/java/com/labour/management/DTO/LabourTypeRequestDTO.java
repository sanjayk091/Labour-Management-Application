package com.labour.management.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LabourTypeRequestDTO {
    private String name;
    private CategoryRequestDTO category;
}
