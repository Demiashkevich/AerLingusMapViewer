package com.aerlingus.controller;

import com.aerlingus.service.TrafficInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @Autowired
  TrafficInfoService trafficInfoService;

  @GetMapping(value = "/trafficInfo/")
  public String getTrafficInfo() {
    return trafficInfoService.getTrafficInfo();
  }

  @GetMapping(value = "/trafficInfo/add/")
  public void addTraficInfo(){
    trafficInfoService.addTrafficInfo();
  }
}
