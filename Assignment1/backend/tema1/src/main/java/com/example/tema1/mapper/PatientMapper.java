package com.example.tema1.mapper;

import com.example.tema1.dto.PatientDTO;
import com.example.tema1.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class PatientMapper {
    public abstract Patient toEntity(PatientDTO patientDTO);


    public abstract void toEntityUpdate(@MappingTarget Patient patient, PatientDTO patientDTO);


    public abstract PatientDTO toDTO(Patient patient);

}
