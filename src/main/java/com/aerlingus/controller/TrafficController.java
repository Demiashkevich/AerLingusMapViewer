package com.aerlingus.controller;

import com.aerlingus.dto.AirportInfoDto;
import com.aerlingus.service.TrafficInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "TrafficController", description = "Traffic controller")
public class TrafficController {

  @Autowired
  private TrafficInfoService trafficService;

  @GetMapping(value = "/traffics/")
  @ApiOperation("View all traffic")
  public List<AirportInfoDto> getAirportInfo() {
    return trafficService.getAirportInfos();
  }

  @GetMapping(value = "/traffics/{airportCode}")
  @ApiOperation("View the particular traffic by airportCode")
  public AirportInfoDto getAirportInfo(@PathVariable(value = "airportCode") String airportCode) {
    return trafficService.getAirportInfo(airportCode);
  }

}
