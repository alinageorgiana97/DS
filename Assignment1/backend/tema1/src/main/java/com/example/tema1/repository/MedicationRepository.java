package com.example.tema1.repository;

import com.example.tema1.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicationRepository extends JpaRepository<Medication,Long> {
    Optional<Medication> findById(Long id);
}
