package com.hoangquocuy.mess_be.entities;

import javax.persistence.*;

@Entity
@Table(name = "friend")
public class FriendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "me")
    private UserEntity me;

    @ManyToOne
    @JoinColumn(name = "my_friend")
    private UserEntity myFriend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getMe() {
        return me;
    }

    public void setMe(UserEntity me) {
        this.me = me;
    }

    public UserEntity getMyFriend() {
        return myFriend;
    }

    public void setMyFriend(UserEntity myFriend) {
        this.myFriend = myFriend;
    }
}
