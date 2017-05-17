package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.LogMessage;
import com.greenfoxacademy.models.User;
import com.greenfoxacademy.repository.UserRepo;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bálint on 2017. 05. 17..
 */
@Controller
@RequestMapping("/")
public class MainController {

  @Autowired
  private UserRepo userRepo;

  @GetMapping
  public String main(){
    String loglevel = System.getenv("CHAT_APP_LOGLEVEL");
    System.out.println(new LogMessage(new Timestamp(System.currentTimeMillis()), loglevel,
        "/", "GET", "").toString());
    return "index";
  }

  @GetMapping("/enter")
  public String enter() {
    return "enter";
  }

  @GetMapping("/enter/hit")
  public String hit(String username) {
    //userRepo.findByUsername(username)
    userRepo.save(new User(username));
    return "redirect:/";
  }
}
