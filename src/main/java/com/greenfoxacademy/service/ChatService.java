package com.greenfoxacademy.service;

import com.greenfoxacademy.models.ChatClient;
import com.greenfoxacademy.models.ChatMessage;
import com.greenfoxacademy.models.ChatReceived;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Bálint on 2017. 05. 17..
 */
public class ChatService {
  private String url = "https://peertopeerchatapp.herokuapp.com/api/message/receive";
  private RestTemplate restTemplate = new RestTemplate();

  @Autowired
  private ChatReceived chatReceived;

  public ChatReceived sendTo(ChatMessage message, ChatClient client) {
    chatReceived.setMessage(message);
    chatReceived.setClient(client);
    ChatReceived sentMessage = restTemplate.postForObject(url, chatReceived, ChatReceived.class);
    return sentMessage;
  }
}
