package com.greenfoxacademy.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by Bálint on 2017. 05. 22..
 */
@Getter
@Setter
@Component
public class ChatClient {
  String id;

  @Override
  public String toString() {
    return "ChatClient{" +
        "id='" + id + '\'' +
        '}';
  }
}
