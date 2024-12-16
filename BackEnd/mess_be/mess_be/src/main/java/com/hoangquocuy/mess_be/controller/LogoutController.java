package com.hoangquocuy.mess_be.controller;

import com.hoangquocuy.mess_be.entities.UserEntity;
import com.hoangquocuy.mess_be.service.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class LogoutController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/api/logout/{id}")
    public void logout (@PathVariable("id") int id){

        UserEntity userEntity = userServiceImpl.getUser(id);
        if(userEntity != null) {
            userEntity.setStatus("OF_LINE");
            userServiceImpl.updateUserStatus(userEntity);
        }

    }
}
