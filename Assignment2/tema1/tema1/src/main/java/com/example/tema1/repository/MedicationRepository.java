package com.example.tema1.repository;

import com.example.tema1.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {
    Optional<Medication> findById(Long id);
}
