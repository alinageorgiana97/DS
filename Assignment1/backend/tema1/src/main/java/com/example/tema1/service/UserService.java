package com.example.tema1.service;

import com.example.tema1.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDto);

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO login(String username, String password);
}
