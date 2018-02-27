package com.aerlingus.controller;

import com.aerlingus.service.TrafficInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "IActionController", description = "Action controller")
public class ActionController {

  @Autowired
  private TrafficInfoService trafficService;

  @GetMapping(value = "/action/save")
  public void addTrafficInfo(){
    trafficService.addTrafficInfo();
  }

  @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR,
      reason="Adding traffic info error")
  @ExceptionHandler(Exception.class)
  public void error() {
  }
}
