package com.hoangquocuy.mess_be.model.mapper;

import com.hoangquocuy.mess_be.entities.FriendEntity;
import com.hoangquocuy.mess_be.model.dto.FriendDTO;

import java.util.ArrayList;
import java.util.List;

public class FriendMapper {

    public static List<FriendDTO> mappFriendDto(List<FriendEntity> friends) {
        List<FriendDTO> dtos = new ArrayList<>();
        for(FriendEntity entities : friends) {
            FriendDTO dto = new FriendDTO();
            dto.setFullName(entities.getMyFriend().getFullName());
            dto.setId(entities.getMyFriend().getId());
            dto.setStatus(entities.getMyFriend().getStatus());
            dto.setImage(entities.getMyFriend().getImage());
            dtos.add(dto);
        }
        return dtos;
    }
}
