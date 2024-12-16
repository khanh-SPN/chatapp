package com.hoangquocuy.mess_be.model.mapper;

import com.hoangquocuy.mess_be.entities.FriendEntity;
import com.hoangquocuy.mess_be.entities.UserEntity;
import com.hoangquocuy.mess_be.model.dto.FriendDTO;
import com.hoangquocuy.mess_be.model.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDTO mappUserDto (UserEntity userEntity) {

            UserDTO dto = new UserDTO();
            dto.setFullName(userEntity.getFullName());
            dto.setId(userEntity.getId());
            dto.setStatus(userEntity.getStatus());
            dto.setImage(userEntity.getImage());
            dto.setEmail(userEntity.getEmail());

        return dto;
    }
}
