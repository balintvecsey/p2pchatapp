package com.greenfoxacademy.repository;

import com.greenfoxacademy.models.ChatMessage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bálint on 2017. 05. 18..
 */
public interface ChatMessageRepo extends CrudRepository<ChatMessage, Long> {
  ChatMessage findByUsername(String username);
}
