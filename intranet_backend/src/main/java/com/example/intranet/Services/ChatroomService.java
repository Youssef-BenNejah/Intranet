package com.example.intranet.Services;

import com.example.intranet.entities.Chat.ChatRoom;
import com.example.intranet.repositories.ChatroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatroomService {
    @Autowired
    private ChatroomRepository chatroomRepository;
    public String getChatRoomId(String senderId,
                                          String recepionId,
                                          boolean createChatroomIfNotExist){
       if (!createChatroomIfNotExist){
       var chatroom = chatroomRepository.findBySenderIdAndRecipientId(senderId,recepionId);

        if (!createChatroomIfNotExist){
            return chatroom.getChatId();
        }

        }return createChat(senderId,recepionId);

    }

    private String createChat(String senderId, String recepionId) {
        var chatId= String.format("%s-%s",senderId,recepionId);
        var SenderRecipient =ChatRoom.builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recepionId)
                .build();


        var recipientSender =ChatRoom.builder()
                .chatId(chatId)
                .senderId(recepionId)
                .recipientId(senderId)
                .build();
        chatroomRepository.save(SenderRecipient);
        chatroomRepository.save(recipientSender);
        return chatId;

    }
}
