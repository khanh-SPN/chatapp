package com.hoangquocuy.mess_be.service.serviceimpl;

import com.hoangquocuy.mess_be.entities.FriendEntity;
import com.hoangquocuy.mess_be.repository.FriendRepository;
import com.hoangquocuy.mess_be.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public List<FriendEntity> getMyFriends(int id) {
        return friendRepository.findByMe_Id(id);
    }
}
