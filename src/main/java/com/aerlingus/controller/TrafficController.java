package com.aerlingus.controller;

import com.aerlingus.dto.CityInfoDto;
import com.aerlingus.service.TrafficInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrafficController {

  @Autowired
  TrafficInfoService trafficService;

  @GetMapping(value = "/traffics/")
  public List<CityInfoDto> getTrafficInfo() {
    return trafficService.getTrafficInfo();
  }

  @GetMapping(value = "/traffics/add/")
  public void addTrafficInfo(){
    trafficService.addTrafficInfo();
  }

}
