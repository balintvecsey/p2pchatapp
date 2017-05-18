package com.greenfoxacademy.repository;

import com.greenfoxacademy.models.ChatUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bálint on 2017. 05. 17..
 */
public interface ChatUserRepo extends CrudRepository<ChatUser, Long> {
  ChatUser findByUsername(String username);
}
