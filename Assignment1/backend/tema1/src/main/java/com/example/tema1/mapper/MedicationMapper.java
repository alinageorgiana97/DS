package com.example.tema1.mapper;

import com.example.tema1.dto.MedicationDTO;
import com.example.tema1.entity.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class MedicationMapper {
    public abstract Medication toEntity(MedicationDTO medicationDTO);

    public abstract void toEntityUpdate(@MappingTarget Medication medication, MedicationDTO medicationDTO);


    public abstract MedicationDTO toDTO(Medication medication);

}
