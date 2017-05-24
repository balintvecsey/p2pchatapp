package com.greenfoxacademy.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Created by Bálint on 2017. 05. 21..
 */
@Getter
@Setter
public class StatusMessage {
  private String status;
  private HttpStatus statusCode;

  public StatusMessage() {
  }

  public StatusMessage(String status, HttpStatus statusCode) {
    this.status = status;
    this.statusCode = statusCode;
  }

}
