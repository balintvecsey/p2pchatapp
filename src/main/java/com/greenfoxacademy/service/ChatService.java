package com.greenfoxacademy.service;

import com.greenfoxacademy.models.ChatClient;
import com.greenfoxacademy.models.ChatMessage;
import com.greenfoxacademy.models.JsonMessage;
import com.greenfoxacademy.models.StatusMessage;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Bálint on 2017. 05. 17..
 */
public class ChatService {
  private String georgeUrl = "https://peertopeerchatapp.herokuapp.com/api/message/receive";
  private String marciUrl = "http://p2p-chat-seed0forever.herokuapp.com/api/message/receive";
  private RestTemplate restTemplate = new RestTemplate();

  private JsonMessage jsonMessage;

  public void sendTo(ChatMessage message, ChatClient client) {
    System.out.println("in sendto" + message);
    jsonMessage = new JsonMessage(message, client);
    System.out.println(jsonMessage);
    StatusMessage messsageResponse = restTemplate.postForObject(marciUrl, jsonMessage, StatusMessage.class);
  }
}
