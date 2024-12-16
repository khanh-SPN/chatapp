package com.hoangquocuy.mess_be.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "from_by")
    private UserEntity fromBy;

    @ManyToOne
    @JoinColumn(name = "to_by")
    private UserEntity toBy;

    @Column(name = "time_send")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "HH:MI:SS")
    private Date timeSend;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public UserEntity getToBy() {
        return toBy;
    }

    public void setToBy(UserEntity toBy) {
        this.toBy = toBy;
    }

    public Date getTimeSend() {
        return timeSend;
    }

    public void setTimeSend(Date timeSend) {
        this.timeSend = timeSend;
    }

    public UserEntity getFromBy() {
        return fromBy;
    }

    public void setFromBy(UserEntity fromBy) {
        this.fromBy = fromBy;
    }
}
