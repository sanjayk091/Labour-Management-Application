package com.labour.management.Repository;

import com.labour.management.Entity.LabourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabourRepository extends JpaRepository<LabourEntity, Long> {
    List<LabourEntity> findByIsAvailableTrue();

    List<LabourEntity> findByLabourType_Name(String typeName); // ✅ Fixed

    List<LabourEntity> findByLabourType_NameAndIsAvailable(String typeName, boolean isAvailable); // ✅ Fixed

}
