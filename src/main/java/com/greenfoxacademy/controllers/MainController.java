package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.ChatClient;
import com.greenfoxacademy.models.ChatMessage;
import com.greenfoxacademy.models.ErrorMessage;
import com.greenfoxacademy.models.LogMessage;
import com.greenfoxacademy.models.ChatUser;
import com.greenfoxacademy.repository.ChatMessageRepo;
import com.greenfoxacademy.repository.ChatUserRepo;
import com.greenfoxacademy.service.ChatService;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
  private ChatMessageRepo chatMessageRepo;

  @Autowired
  private ChatUser user;

  @GetMapping
  public String main(Model model, @RequestParam(name = "error", required = false) String error){
    String loglevel = System.getenv("CHAT_APP_LOGLEVEL");
    if(chatUserRepo.findOne(1L) == null) {
      return "enter";
    } else {
      ErrorMessage e = new ErrorMessage(error);
      model.addAttribute("username", chatUserRepo.findOne(1L).getUsername());
      model.addAttribute("error", e.getError());
      model.addAttribute("messages", chatMessageRepo.findAll());
      System.out.println(new LogMessage(new Timestamp(System.currentTimeMillis()), loglevel,
          "/", "GET", ""));
      return "index";
    }
  }

  @GetMapping("/enter")
  public String enter(Model model, @RequestParam(name = "error", required = false) String error) {
    ErrorMessage e = new ErrorMessage(error);
    model.addAttribute("error", e.getError());
    return "newenter";
  }

  @GetMapping("/update/hit")
  public String updateHit(String username) {
    if(username.equals("")) {
      System.out.println(new Timestamp(System.currentTimeMillis()) + " INFO save:false redirect:/enter from:/enter/hit");
      return "redirect:/?error=The?username?field?is?empty";
    } else if(chatUserRepo.findOne(1L) != null && chatUserRepo.findOne(1L).getUsername().equals(username)) {
      System.out.println(new Timestamp(System.currentTimeMillis()) + " " + username + " INFO find:true redirect:/ from:/");
      return "redirect:/";
    } else {
      System.out.println(new Timestamp(System.currentTimeMillis())+ " "+ username + " INFO find:false redirect:/enter from:/");
      return "redirect:/enter";
    }
  }

  @GetMapping("enter/hit")
  public String enterHit(@RequestParam String username) {
    if(username.equals("")) {
      System.out.println(new Timestamp(System.currentTimeMillis()) + " INFO save:false redirect:/enter from:/enter/hit");
      return "redirect:/enter?error=The?username?field?is?empty";
    } else if(chatUserRepo.findOne(1L) != null && chatUserRepo.findOne(1L).getUsername().equals(username)) {
      System.out.println(new Timestamp(System.currentTimeMillis()) + " " + username + " INFO find:true redirect:/ from:/enter/hit");
      return "redirect:/";
    } else {
      user.setUsername(username);
      user.setId(1L);
      chatUserRepo.save(user);
      System.out.println(new Timestamp(System.currentTimeMillis()) + " INFO save:true redirect:/ from:/enter/hit");
      return "redirect:/";
    }
  }

  @GetMapping("/send/hit")
  public String saveMessage(String text) {
    ChatMessage newmessage = new ChatMessage(chatUserRepo.findOne(1L).getUsername(), text);
    chatMessageRepo.save(newmessage);
    ChatClient client = new ChatClient();
    ChatService chatService = new ChatService();

    client.setId(System.getenv("CHAT_APP_UNIQUE_ID"));
    System.out.println(newmessage);
    chatService.sendTo(newmessage, client);
    return "redirect:/";
  }
}
