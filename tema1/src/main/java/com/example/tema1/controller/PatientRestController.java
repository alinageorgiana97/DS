package com.example.tema1.controller;

import com.example.tema1.dto.PatientDTO;
import com.example.tema1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientRestController {

    private final PatientService patientService;

    @Autowired
    public PatientRestController (PatientService patientService){
        this.patientService=patientService;
    }

    @GetMapping("/list")
    public List<PatientDTO> list(){return patientService.findAll();}

    @PostMapping("/save")
    public PatientDTO save(@RequestBody PatientDTO patientDto) {
        return patientService.save(patientDto);
    }


    @GetMapping(path = "/{id}")
    public PatientDTO find(@PathVariable("id") Long id) {
        return patientService.findById(id);
    }

}
