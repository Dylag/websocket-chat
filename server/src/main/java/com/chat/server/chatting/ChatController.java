package com.chat.server.chatting;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/currentChat")
    public Message message (HelloMessage message){
        return new Message("hello message");
    }
}
