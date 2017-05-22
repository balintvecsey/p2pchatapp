package com.greenfoxacademy.service;

import com.greenfoxacademy.models.ChatClient;
import com.greenfoxacademy.models.ChatMessage;
import com.greenfoxacademy.models.ChatReceived;
import com.greenfoxacademy.models.StatusMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Bálint on 2017. 05. 17..
 */
public class ChatService {
  private String url = "https://peertopeerchatapp.herokuapp.com/api/message/receive";
  private String url1 = "http://p2p-chat-seed0forever.herokuapp.com/api/message/receive";
  private RestTemplate restTemplate = new RestTemplate();

  @Autowired
  private ChatReceived chatReceived;

  public void sendTo(ChatMessage message, ChatClient client) {
    chatReceived.setMessage(message);
    chatReceived.setClient(client);
    StatusMessage messsageResponse = restTemplate.postForObject(url1, chatReceived, StatusMessage.class);
  }
}
