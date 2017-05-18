package com.greenfoxacademy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by Bálint on 2017. 05. 17..
 */
@Getter
@Setter
@Entity
@Component
public class ChatUser {

  @Id
  private long id;
  private String username;

  public ChatUser() {

  }

  public ChatUser(String username) {
    this.username = username;
  }
}
