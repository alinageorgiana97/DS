package com.example.tema1.mapper;

import com.example.tema1.dto.CaregiverDTO;
import com.example.tema1.entity.Caregiver;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class CaregiverMapper {
    public abstract Caregiver toEntity(CaregiverDTO caregiverDTO);

    public abstract void toEntityUpdate(@MappingTarget Caregiver caregiver, CaregiverDTO caregiverDTO);

    public abstract CaregiverDTO toDTO(Caregiver caregiver);

}
