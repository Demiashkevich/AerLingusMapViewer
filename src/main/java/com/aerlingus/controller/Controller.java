package com.aerlingus.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private static final Logger logger = Logger.getLogger(Controller.class);

  @GetMapping(value = "/trafficInfo/")
  public String getTrafficInfo() {
    return "123";
  }

}
