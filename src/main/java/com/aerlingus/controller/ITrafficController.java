package com.aerlingus.controller;


import com.aerlingus.dto.AirportInfoDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ITrafficController {

  @ApiOperation("View all traffic")
  List<AirportInfoDto> getAirportInfo();

  @ApiOperation("View the particular traffic by destination")
  AirportInfoDto getAirportInfo(@PathVariable(value = "destination") String destination);

}
