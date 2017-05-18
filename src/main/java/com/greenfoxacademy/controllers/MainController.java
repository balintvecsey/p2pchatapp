package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.LogMessage;
import com.greenfoxacademy.models.ChatUser;
import com.greenfoxacademy.repository.ChatUserRepo;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Bálint on 2017. 05. 17..
 */
@Controller
@RequestMapping("/")
public class MainController {

  @Autowired
  private ChatUserRepo chatUserRepo;
  @Autowired
  private ChatUser user;

  @GetMapping
  public String main(Model model){
    if(chatUserRepo.findOne(1L) != null) {
      model.addAttribute("username", chatUserRepo.findOne(1L).getUsername());
    }
    String loglevel = System.getenv("CHAT_APP_LOGLEVEL");

    System.out.println(new LogMessage(new Timestamp(System.currentTimeMillis()), loglevel,
        "/", "GET", ""));
    return "index";
  }

  @GetMapping("/enter")
  public String enter() {
    return "enter";
  }

  @GetMapping("/update/hit")
  public String updateHit(String username) {
    if(chatUserRepo.findOne(1L) == null || !chatUserRepo.findOne(1L).getUsername().equals(username)) {
      System.out.println(new Timestamp(System.currentTimeMillis())+ " "+ username + " INFO find:false redirect:/enter from:/");
      return "redirect:/enter";
    } else {
      System.out.println(new Timestamp(System.currentTimeMillis()) + " " + username + " INFO find:true redirect:/ from:/");
      return "redirect:/";
    }
  }

  @GetMapping("enter/hit")
  public String enterHit(String username) {
    if(username.equals("")) {
      System.out.println(new Timestamp(System.currentTimeMillis()) + " INFO save:false redirect:/enter from:/enter/hit");
      return "redirect:/enter";
    } else {
      user.setUsername(username);
      user.setId(1L);
      chatUserRepo.save(user);
      System.out.println(new Timestamp(System.currentTimeMillis()) + " INFO save:true redirect:/ from:/enter/hit");
    }
    return "redirect:/";
  }
}
