package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.ChatClient;
import com.greenfoxacademy.models.ChatMessage;
import com.greenfoxacademy.models.ChatReceived;
import com.greenfoxacademy.models.ChatUser;
import com.greenfoxacademy.models.StatusMessage;
import com.greenfoxacademy.repository.ChatMessageRepo;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
  public StatusMessage receiveMessage(@RequestBody ChatReceived input) {
    ChatMessage message = input.getMessage();
    if (message.getUsername() != null && message.getText() != null) {
      chatMessageRepo.save(message);
      return new StatusMessage("ok");
    }
    return new StatusMessage("error");
  }
}
