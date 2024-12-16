package com.hoangquocuy.mess_be.service.serviceimpl;

import com.hoangquocuy.mess_be.entities.MessageEntity;
import com.hoangquocuy.mess_be.repository.MessageRepository;
import com.hoangquocuy.mess_be.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<MessageEntity> getMessage(int id1, int id2) {
        return messageRepository.getMessages(id1,id2,id2,id1);
    }

    @Override
    public void saveMessage(MessageEntity message) {
        messageRepository.save(message);
    }
}
