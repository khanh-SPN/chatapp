package com.hoangquocuy.mess_be.service;

import com.hoangquocuy.mess_be.entities.FriendEntity;

import java.util.List;

public interface FriendService {

    public List<FriendEntity> getMyFriends(int id);
}
