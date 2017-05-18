package com.greenfoxacademy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by Bálint on 2017. 05. 18..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ErrorMessage {

  private String error;
}
