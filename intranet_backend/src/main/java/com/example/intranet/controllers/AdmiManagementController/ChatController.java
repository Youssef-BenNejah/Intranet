package com.example.intranet.controllers.AdmiManagementController;

import com.example.intranet.Services.MessageService;
import com.example.intranet.entities.Chat.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/chat.user")
    public void sendMessage(
            @Payload Message message
    ){
        Message message1= messageService.saveMessage(message);
        messagingTemplate.convertAndSendToUser(message1.getRecipientId(),"/queue/message",message.builder()
                .id(message1.getId())
                .senderId(message1.getSenderId())
                .recipientId(message1.getRecipientId())
                .content(message1.getContent())
                .build());
    }
    @GetMapping("/message/{senderId}/{recipientId}")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String senderId,@PathVariable String recipientId ){
        return ResponseEntity.ok(messageService.ListMessages(senderId,recipientId));
    }

}
