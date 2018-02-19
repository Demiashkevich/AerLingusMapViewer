package com.aerlingus.controller;

import com.aerlingus.dto.AirportInfoDto;
import com.aerlingus.service.TrafficInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrafficController implements ITrafficController{

  @Autowired
  private TrafficInfoService trafficService;

  @GetMapping(value = "/traffics/")
  public List<AirportInfoDto> getAirportInfo() {
    return trafficService.getTrafficInfo();
  }

  @GetMapping(value = "/traffics/{destination}")
  public AirportInfoDto getAirportInfo(@PathVariable(value = "destination") String destination) {
    return null;
  }

}
