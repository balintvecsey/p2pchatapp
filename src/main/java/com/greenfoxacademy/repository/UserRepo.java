package com.greenfoxacademy.repository;

import com.greenfoxacademy.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bálint on 2017. 05. 17..
 */
public interface UserRepo extends CrudRepository<User, Long> {
  User findByUsername(String username);
}
