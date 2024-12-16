package com.hoangquocuy.mess_be.controller;

import com.hoangquocuy.mess_be.entities.MessageEntity;
import com.hoangquocuy.mess_be.entities.UserEntity;
import com.hoangquocuy.mess_be.model.dto.MessageDTO;
import com.hoangquocuy.mess_be.model.mapper.MessageMapper;
import com.hoangquocuy.mess_be.service.serviceimpl.MessageServiceImpl;
import com.hoangquocuy.mess_be.service.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
public class MessageController {

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/api/message/{id1}/{id2}")
    public List<MessageDTO> getMessages (@PathVariable("id1") int id1,
                                         @PathVariable("id2") int id2) {
        return MessageMapper.mappMessageDto(messageServiceImpl.getMessage(id1,id2));
    }

    @GetMapping("/api/annex-message/{fromId}/{toId}/{content}")
    public void addMessage (@PathVariable("fromId") int fromId,
                            @PathVariable("toId") int toId,
                            @PathVariable("content") String content) {
        MessageEntity newMessage = new MessageEntity();

        UserEntity from = userServiceImpl.getUser(fromId);

        UserEntity to = userServiceImpl.getUser(toId);

        newMessage.setContent(content);

        newMessage.setFromBy(from);

        newMessage.setToBy(to);

        newMessage.setTimeSend(new Date());

        messageServiceImpl.saveMessage(newMessage);

    }

}
