package com.hoangquocuy.mess_be.repository;

import com.hoangquocuy.mess_be.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmailAndPassword(String email, String password);
}
