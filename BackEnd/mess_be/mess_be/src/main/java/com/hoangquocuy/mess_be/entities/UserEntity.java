package com.hoangquocuy.mess_be.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    private String password;

    private String email;

    private String status;

    private String image;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "me")
    private List<FriendEntity> mes ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "myFriend")
    private List<FriendEntity> myFriend ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fromBy")
    private List<MessageEntity> messagesFrom ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "toBy")
    private List<MessageEntity> messagesTo ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<FriendEntity> getMes() {
        return mes;
    }

    public void setMes(List<FriendEntity> mes) {
        this.mes = mes;
    }

    public List<FriendEntity> getMyFriend() {
        return myFriend;
    }

    public void setMyFriend(List<FriendEntity> myFriend) {
        this.myFriend = myFriend;
    }

    public List<MessageEntity> getMessagesFrom() {
        return messagesFrom;
    }

    public void setMessagesFrom(List<MessageEntity> messagesFrom) {
        this.messagesFrom = messagesFrom;
    }

    public List<MessageEntity> getMessagesTo() {
        return messagesTo;
    }

    public void setMessagesTo(List<MessageEntity> messagesTo) {
        this.messagesTo = messagesTo;
    }
}
