package com.example.tema1.controller;

import com.example.tema1.dto.LoginDTO;
import com.example.tema1.dto.UserDTO;
import com.example.tema1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(value="http://localhost:4200")
@RestController
@RequestMapping(value="/user")
public class UserRestController {

    private final UserService userService;


    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public UserDTO save(@RequestBody UserDTO userDto) {
        return userService.save(userDto);
    }
    @GetMapping(path = "/{id}")
    public UserDTO find(@PathVariable("id") Long id) {
        return userService.findById(id);
    }


    @PostMapping(path = "/login")
    public UserDTO login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO.getUsername(), loginDTO.getPassword());
    }

}