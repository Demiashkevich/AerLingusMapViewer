package com.aerlingus.controller;

import com.aerlingus.service.TrafficInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController implements IActionController {

  @Autowired
  private TrafficInfoService trafficService;

  @GetMapping(value = "/action/save")
  public void addTrafficInfo(){
    trafficService.addTrafficInfo();
  }

}
