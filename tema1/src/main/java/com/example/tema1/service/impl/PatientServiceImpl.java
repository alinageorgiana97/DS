package com.example.tema1.service.impl;

import com.example.tema1.dto.PatientDTO;
import com.example.tema1.entity.Patient;
import com.example.tema1.mapper.PatientMapper;
import com.example.tema1.repository.PatientRepository;
import com.example.tema1.service.PatientService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
@Service
public class PatientServiceImpl implements PatientService
{

    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;


    public PatientServiceImpl(PatientMapper patientMapper, PatientRepository patientRepository) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        Patient patient;

        if (patientDTO.getId() != null) {
            patient = patientRepository.findById(patientDTO.getId()).get();
        } else {
            patient = new Patient();
        }
        patientMapper.toEntityUpdate(patient, patientDTO);
        return patientMapper.toDTO(patientRepository.save(patient));
    }
    @Override
    public List<PatientDTO> findAll() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO findById(Long id) {
        return patientMapper.toDTO(patientRepository.findById(id).get());
    }
}
