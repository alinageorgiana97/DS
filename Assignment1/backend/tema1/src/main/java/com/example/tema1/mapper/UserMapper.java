package com.example.tema1.mapper;

import com.example.tema1.dto.UserDTO;
import com.example.tema1.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class UserMapper {
    public abstract User toEntity(UserDTO userDTO);


    public abstract void toEntityUpdate(@MappingTarget User user, UserDTO userDTO);


    public abstract UserDTO toDTO(User user);

}
