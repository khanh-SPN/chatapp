package com.hoangquocuy.mess_be.controller;

import com.hoangquocuy.mess_be.entities.UserEntity;
import com.hoangquocuy.mess_be.model.dto.MessageDTO;
import com.hoangquocuy.mess_be.model.dto.UserDTO;
import com.hoangquocuy.mess_be.model.mapper.MessageMapper;
import com.hoangquocuy.mess_be.model.mapper.UserMapper;
import com.hoangquocuy.mess_be.service.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class LoginController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/api/login/{email}/{password}")
    public UserDTO getMessages (@PathVariable("email") String email,
                                @PathVariable("password") String password) {
        UserDTO dto = new UserDTO();
        UserEntity userEntity = userServiceImpl.getUserByEmail(email,password);
        if(userEntity != null) {
            UserEntity userEntityUpdateStatus = userServiceImpl.getUserByEmail(email,password);
            userEntityUpdateStatus.setStatus("ONLINE");
            userServiceImpl.updateUserStatus(userEntityUpdateStatus);
            return UserMapper.mappUserDto(userEntity);
        }
        return dto;
    }
}
