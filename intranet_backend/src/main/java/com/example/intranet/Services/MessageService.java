package com.example.intranet.Services;

import com.example.intranet.entities.Chat.Message;
import com.example.intranet.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    @Autowired
    private ChatroomService chatroomService ;
    private MessageRepository repository ;

    public Message saveMessage(Message message){
        var chatId = chatroomService.getChatRoomId(message.getSenderId(),
                message.getRecipientId(),true);
        message.setChatId(String.valueOf(chatId));
        repository.save(message);
        return message;

    }
    public List<Message> ListMessages(String sendrId, String recipientId){
        var chatId = chatroomService.getChatRoomId(sendrId,recipientId,false);
        return repository.findByChatId(chatId);
    }

}
