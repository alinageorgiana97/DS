package com.example.tema1.service;

import com.example.tema1.dto.CaregiverDTO;

import java.util.List;

public interface CaregiverService {
    CaregiverDTO save(CaregiverDTO caregiverDTO);

    List<CaregiverDTO> findAll();

    CaregiverDTO findById(Long id);
}
