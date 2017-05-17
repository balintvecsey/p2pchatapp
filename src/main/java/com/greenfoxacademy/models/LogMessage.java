package com.greenfoxacademy.models;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by Bálint on 2017. 05. 17..
 */
@Getter
@Setter
@Component
public class LogMessage {
  private String path;
  private String method;
  private Timestamp timestamp;
  private String loglevel;
  private String requestdata;

  public LogMessage() {

  }

  public LogMessage(Timestamp timestamp, String loglevel, String path, String method, String requestdata ) {
    this.timestamp = timestamp;
    this.loglevel = loglevel;
    this.path = path;
    this.method = method;
    this.requestdata = requestdata;
  }

  @Override
  public String toString() {
    return timestamp + "  " + loglevel + " Request " + path + " " + method + " " + requestdata;
  }
}
