package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.LogMessage;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bálint on 2017. 05. 17..
 */
@Controller
public class MainController {

  @RequestMapping("/")
  public String main(){
    String loglevel = System.getenv("CHAT_APP_LOGLEVEL");
    System.out.println(new LogMessage(new Timestamp(System.currentTimeMillis()), "INFO",
        "/", "GET", "").toString());
    return "index";
  }
}
