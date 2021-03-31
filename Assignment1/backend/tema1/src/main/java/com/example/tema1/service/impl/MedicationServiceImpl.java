package com.example.tema1.service.impl;

import com.example.tema1.dto.MedicationDTO;
import com.example.tema1.entity.Medication;
import com.example.tema1.mapper.MedicationMapper;
import com.example.tema1.repository.MedicationRepository;
import com.example.tema1.service.MedicationService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
@Service
public class MedicationServiceImpl implements MedicationService {



    private final MedicationMapper medicationMapper;
    private final MedicationRepository medicationRepository;


    public MedicationServiceImpl(MedicationMapper medicationMapper, MedicationRepository medicationRepository) {
        this.medicationMapper = medicationMapper;
        this.medicationRepository = medicationRepository;
    }

    @Override
    public MedicationDTO save(MedicationDTO medicationDTO) {
        Medication medication;

        if (medicationDTO.getId() != null) {
            medication = medicationRepository.findById(medicationDTO.getId()).get();
        } else {
            medication= new Medication();
        }
        medicationMapper.toEntityUpdate(medication, medicationDTO);
        return medicationMapper.toDTO(medicationRepository.save(medication));
    }
    @Override
    public List<MedicationDTO> findAll() {
        return medicationRepository.findAll()
                .stream()
                .map(medicationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicationDTO findById(Long id) {
        return medicationMapper.toDTO(medicationRepository.findById(id).get());
    }
}
