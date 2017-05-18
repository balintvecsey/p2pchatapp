package com.greenfoxacademy.models;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by Bálint on 2017. 05. 18..
 */
@Getter
@Setter
@Entity
@Component
public class ChatMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String username;
  String text;
  Timestamp timestamp;

  public ChatMessage() {
    timestamp = new Timestamp(System.currentTimeMillis());
  }

  public ChatMessage(String username, String text) {
    this.username = username;
    this.text = text;
  }
}
