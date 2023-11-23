package com.example.intranet.repositories;

import com.example.intranet.entities.Chat.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatroomRepository extends JpaRepository<ChatRoom,Long> {
    ChatRoom findBySenderIdAndRecipientId(String senderId,String recipientId);;
}
