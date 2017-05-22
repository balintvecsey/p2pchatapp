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
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ChatReceived {
  private ChatMessage message;
  private ChatClient client;

}
