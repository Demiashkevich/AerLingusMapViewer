package com.aerlingus.controller;

import com.aerlingus.dto.AirportInfoDto;
import com.aerlingus.service.TrafficInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Api(value = "TrafficController", description = "Traffic controller")
public class TrafficController {

  @Autowired
  private TrafficInfoService trafficService;

  @GetMapping(value = "/traffics")
  @ApiOperation("View all traffic")
  public List<AirportInfoDto> getAirportInfo(@RequestParam("startDate") String startDate,
      @RequestParam("endDate") String endDate) {
    return trafficService.getAirportInfos(startDate,endDate);
  }

  @GetMapping(value = "/traffics/{airportCode}")
  @ApiOperation("View the particular traffic by airportCode")
  public AirportInfoDto getAirportInfo(@PathVariable(value = "airportCode") String airportCode,
      @RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate) {
    return trafficService.getAirportInfo(airportCode, startDate, endDate);
  }

  @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR,
      reason="Getting airports error")
  @ExceptionHandler(Exception.class)
  public void error() {
  }

}
