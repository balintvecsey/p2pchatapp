package com.greenfoxacademy.models;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by Bálint on 2017. 05. 18..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Component
public class ChatMessage {

  @Id
  private long id = (long) (Math.random() * 9000000L) + 1000000L;
  private String username;
  private String text;
  private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

  public ChatMessage(String username, String text) {
    this.username = username;
    this.text = text;
  }

  public ChatMessage(long id, String username, String text) {
    this.id = id;
    this.username = username;
    this.text = text;
  }

  @Override
  public String toString() {
    return "ChatMessage{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", text='" + text + '\'' +
        ", timestamp=" + timestamp +
        '}';
  }
}
