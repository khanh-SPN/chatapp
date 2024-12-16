package com.hoangquocuy.mess_be.service.serviceimpl;

import com.hoangquocuy.mess_be.entities.UserEntity;
import com.hoangquocuy.mess_be.repository.UserRepository;
import com.hoangquocuy.mess_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserEntity getUser(int userId) {
        Optional<UserEntity> byId = userRepository.findById(userId);
        return byId.get();
    }

    @Override
    public UserEntity getUserByEmail(String email, String password) {
       return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public void updateUserStatus(UserEntity userUpdate) {
        userRepository.save(userUpdate);
    }
}
