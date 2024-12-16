package com.hoangquocuy.mess_be.controller;

import com.hoangquocuy.mess_be.entities.FriendEntity;
import com.hoangquocuy.mess_be.model.dto.FriendDTO;
import com.hoangquocuy.mess_be.model.mapper.FriendMapper;
import com.hoangquocuy.mess_be.service.serviceimpl.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin("*")
@RestController
public class FriendController {

    @Autowired
    private FriendServiceImpl friendServiceImpl;

    @GetMapping("/api/my-friend/{id}")
    public List<FriendDTO> getListMyFriend(@PathVariable("id") int id) {
        List<FriendEntity> friendsEntity = friendServiceImpl.getMyFriends(id);
        List<FriendDTO> getMyFriends = FriendMapper.mappFriendDto(friendsEntity);
        return getMyFriends;

    }

}
