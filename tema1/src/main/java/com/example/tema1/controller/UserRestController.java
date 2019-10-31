package com.example.tema1.controller;

import com.example.tema1.dto.UserDTO;
import com.example.tema1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/list")
    public List<UserDTO> list() {
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

    @GetMapping(path = "/login/{username}/{password}")
    public UserDTO login(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.login(username, password);
    }

}