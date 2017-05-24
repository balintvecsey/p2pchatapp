package com.greenfoxacademy.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bálint on 2017. 05. 21..
 */
@Getter
@Setter
public class StatusMessage {
  private String status;

  public StatusMessage() {
  }

  public StatusMessage(String status) {
    this.status = status;
  }

}
