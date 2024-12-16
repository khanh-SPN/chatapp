package com.hoangquocuy.mess_be.model.mapper;

import com.hoangquocuy.mess_be.entities.MessageEntity;

import com.hoangquocuy.mess_be.model.dto.MessageDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MessageMapper {

    public static List<MessageDTO> mappMessageDto(List<MessageEntity> mesages) {
        List<MessageDTO> dtos = new ArrayList<>();
        for(MessageEntity entities : mesages) {
            MessageDTO dto = new MessageDTO();
            dto.setId(entities.getId());
            dto.setContent(entities.getContent());
            dto.setFrom(entities.getFromBy().getFullName());
            dto.setTo(entities.getToBy().getFullName());
            dto.setImage(entities.getFromBy().getImage());
            dto.setTimeSend(new SimpleDateFormat("hh:mm").format(entities.getTimeSend()));
            dtos.add(dto);
        }
        return dtos;
    }
}
