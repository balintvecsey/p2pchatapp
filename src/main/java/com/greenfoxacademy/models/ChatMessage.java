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
  long id;
  String username;
  String text;
  Timestamp timestamp;

  public ChatMessage() {

  }

  public ChatMessage(String username, String text) {
    this.username = username;
    this.text = text;
    timestamp = new Timestamp(System.currentTimeMillis());
    id = (long) (Math.random() * 9000000L) + 1000000L;
  }

  public ChatMessage(long id, String username, String text) {
    this.id = id;
    this.username = username;
    this.text = text;
  }
}
