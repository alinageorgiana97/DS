package com.example.tema1.service;

import com.example.tema1.dto.MedicationDTO;

import java.util.List;

public interface MedicationService {
    MedicationDTO save(MedicationDTO medicationDTO);

    List<MedicationDTO> findAll();

    MedicationDTO findById(Long id);
}
