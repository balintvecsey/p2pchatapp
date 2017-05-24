package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.ChatClient;
import com.greenfoxacademy.models.ChatMessage;
import com.greenfoxacademy.models.JsonMessage;
import com.greenfoxacademy.models.StatusMessage;
import com.greenfoxacademy.repository.ChatMessageRepo;
import com.greenfoxacademy.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bálint on 2017. 05. 21..
 */
@RestController
public class ChatRestController {

  @Autowired
  private ChatMessageRepo chatMessageRepo;

  @Autowired
  private ChatMessage chatMessage;

  @Autowired
  private ChatClient chatClient;


  @CrossOrigin("*")
  @PostMapping("/api/message/receive")
  public StatusMessage receiveMessage(@RequestBody JsonMessage input) {
    ChatMessage message = input.getMessage();
    if(!input.getClient().getId().equals(System.getenv("CHAT_APP_UNIQUE_ID"))) {
      ChatService chatService = new ChatService();
      chatService.sendTo(input.getMessage(), input.getClient());
      if (message.getUsername() != null && message.getText() != null) {
        chatMessageRepo.save(message);
        return new StatusMessage("ok", HttpStatus.OK);
      }
      return new StatusMessage("error", HttpStatus.BAD_REQUEST);
    }
    return new StatusMessage("ok", HttpStatus.OK);
  }
}
