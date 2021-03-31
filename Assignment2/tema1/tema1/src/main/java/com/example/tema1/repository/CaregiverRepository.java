package com.example.tema1.repository;

import com.example.tema1.entity.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver,Long> {
   Optional<Caregiver> findById(Long id);
}
