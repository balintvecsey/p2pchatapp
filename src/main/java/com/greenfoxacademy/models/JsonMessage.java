package com.greenfoxacademy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by Bálint on 2017. 05. 22..
 */
@Getter

@NoArgsConstructor
@AllArgsConstructor
@Component
public class JsonMessage {
  private ChatMessage message;
  private ChatClient client;

  public void setMessage(ChatMessage message) {
    this.message = message;
  }

  public void setClient(ChatClient client) {
    this.client = client;
  }

  @Override
  public String toString() {
    return "JsonMessage{" +
        "message=" + message +
        ", client=" + client +
        '}';
  }
}
