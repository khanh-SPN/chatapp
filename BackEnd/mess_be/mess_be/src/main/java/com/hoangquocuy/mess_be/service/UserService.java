package com.hoangquocuy.mess_be.service;

import com.hoangquocuy.mess_be.entities.UserEntity;

public interface UserService {

    public UserEntity getUser(int userId);

    public UserEntity getUserByEmail(String email, String password);

    public void updateUserStatus(UserEntity userUpdate);

}
