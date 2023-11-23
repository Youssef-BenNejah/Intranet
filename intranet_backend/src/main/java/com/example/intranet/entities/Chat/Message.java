package com.example.intranet.entities.Chat;

import com.example.intranet.entities.UserEntity.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String chatId;
    private String senderId;
    private String recipientId;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "chatRoom_id")
    private ChatRoom chatRoom;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private Users user;


    @PrePersist
    private void newDate(){timeStamp = new Date();
    }

}
