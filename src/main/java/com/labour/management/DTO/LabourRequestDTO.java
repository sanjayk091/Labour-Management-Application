package com.labour.management.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LabourRequestDTO {
    private String name;
    private String contactNumber;
    private String charges;
    private boolean isActive;
    private boolean isAvailable;
    private LabourTypeRequestDTO labourType;
}
