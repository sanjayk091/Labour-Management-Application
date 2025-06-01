package com.labour.management.Repository;

import com.labour.management.Entity.LabourTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabourTypeRepository extends JpaRepository<LabourTypeEntity,Long> {
    List<LabourTypeEntity> findByCategory_Name(String category);
    Optional<LabourTypeEntity> findByName(String name);
}
