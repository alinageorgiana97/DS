package com.example.tema1.service;

import com.example.tema1.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO save(PatientDTO patientDTO);

    List<PatientDTO> findAll();

    PatientDTO findById(Long id);
    public void deletePatient(Long id);
}
