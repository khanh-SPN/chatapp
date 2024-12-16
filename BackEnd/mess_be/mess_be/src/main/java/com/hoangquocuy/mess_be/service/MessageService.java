package com.hoangquocuy.mess_be.service;

import com.hoangquocuy.mess_be.entities.FriendEntity;
import com.hoangquocuy.mess_be.entities.MessageEntity;

import java.util.List;

public interface MessageService {
    public List<MessageEntity> getMessage(int id1, int id2);

    public void saveMessage(MessageEntity message);
}
