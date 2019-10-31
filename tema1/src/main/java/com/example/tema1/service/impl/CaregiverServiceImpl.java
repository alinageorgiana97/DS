package com.example.tema1.service.impl;


import com.example.tema1.dto.CaregiverDTO;
import com.example.tema1.entity.Caregiver;
import com.example.tema1.mapper.CaregiverMapper;
import com.example.tema1.repository.CaregiverRepository;
import com.example.tema1.service.CaregiverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaregiverServiceImpl implements CaregiverService {

    private final CaregiverMapper caregiverMapper;
    private final CaregiverRepository caregiverRepository;


    public CaregiverServiceImpl(CaregiverMapper caregiverMapper, CaregiverRepository caregiverRepository) {
        this.caregiverMapper = caregiverMapper;
        this.caregiverRepository = caregiverRepository;
    }

    @Override
    public CaregiverDTO save(CaregiverDTO caregiverDTO) {
        Caregiver caregiver;

        if (caregiverDTO.getId() != null) {
            caregiver = caregiverRepository.findById(caregiverDTO.getId()).get();
        } else {
            caregiver = new Caregiver();
        }
        caregiverMapper.toEntityUpdate(caregiver, caregiverDTO);
        return caregiverMapper.toDTO(caregiverRepository.save(caregiver));
    }
    @Override
    public List<CaregiverDTO> findAll() {
        return caregiverRepository.findAll()
                .stream()
                .map(caregiverMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CaregiverDTO findById(Long id) {
        return caregiverMapper.toDTO(caregiverRepository.findById(id).get());
    }
}



