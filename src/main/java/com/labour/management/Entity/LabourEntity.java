package com.labour.management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "labour_details")
public class LabourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactNumber;
    private String charges;
    private boolean isActive;
    private boolean isAvailable;

    @ManyToOne
    private LabourTypeEntity labourType;
}
