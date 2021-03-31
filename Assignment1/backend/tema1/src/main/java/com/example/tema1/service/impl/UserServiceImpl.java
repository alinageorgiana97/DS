package com.example.tema1.service.impl;

import com.example.tema1.dto.UserDTO;
import com.example.tema1.entity.User;
import com.example.tema1.mapper.UserMapper;
import com.example.tema1.repository.UserRepository;
import com.example.tema1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper,
                           UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO save(UserDTO userDto) {

        User user;
        if (userDto.getId() != null) {
            user = userRepository.findById(userDto.getId()).get();
        } else {
            user = new User();
        }

        userMapper.toEntityUpdate(user, userDto);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        return userMapper.toDTO(userRepository.findById(id).get());
    }


    @Override
    public UserDTO login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println("Right pass");
                return userMapper.toDTO(user);
            } else {
                System.out.println("Wrong pass");
                return null;
            }

        }
        return null;

    }
}

