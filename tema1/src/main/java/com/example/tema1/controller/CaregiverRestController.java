package com.example.tema1.controller;

import com.example.tema1.dto.CaregiverDTO;
import com.example.tema1.service.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caregiver")
public class CaregiverRestController {


    private final CaregiverService caregiverService;

    @Autowired
    public CaregiverRestController (CaregiverService caregiverService){
        this.caregiverService=caregiverService;
    }

    @GetMapping("/list")
    public List<CaregiverDTO> list(){return caregiverService.findAll();}

    @PostMapping("/save")
    public CaregiverDTO save(@RequestBody CaregiverDTO caregiverDTO) {
        return caregiverService.save(caregiverDTO);
    }


    @GetMapping(path = "/{id}")
    public CaregiverDTO find(@PathVariable("id") Long id) {
        return caregiverService.findById(id);
    }
}