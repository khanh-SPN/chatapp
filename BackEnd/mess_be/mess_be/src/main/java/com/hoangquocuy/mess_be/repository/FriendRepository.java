package com.hoangquocuy.mess_be.repository;

import com.hoangquocuy.mess_be.entities.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity,Integer> {

    List<FriendEntity> findByMe_Id(int id);
}
