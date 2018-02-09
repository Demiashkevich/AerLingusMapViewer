package com.aerlingus.controller;

import com.aerlingus.dto.CityDto;
import com.aerlingus.converter.JsonConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

  private static final Logger logger = Logger.getLogger(CityController.class);

  @GetMapping(value = "/cities/{cityName}")
  public ResponseEntity<String> readCity(final @PathVariable(value = "cityName") String cityName,
                                         final @RequestParam(required = false) String[] include) {
    CityDto cityDto = new CityDto();
    cityDto.setName("JFK");
    cityDto.setLocationX(1D);
    cityDto.setLocationY(1D);
    cityDto.setBookingCount(100);
    String result = JsonConverter.writer("cityFilter", cityDto, include);
    if (result == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping(value = "/cities")
  public ResponseEntity<String> readCity(final @RequestParam(required = false) String[] include){
    List<CityDto> cityDtoList = new ArrayList<CityDto>();
    CityDto cityDto1 = new CityDto();
    cityDto1.setName("JFK");
    cityDto1.setLocationX(1D);
    cityDto1.setLocationY(1D);
    cityDto1.setBookingCount(100);

    CityDto cityDto2 = new CityDto();
    cityDto2.setName("JFK");
    cityDto2.setLocationX(1D);
    cityDto2.setLocationY(1D);
    cityDto2.setBookingCount(100);

    cityDtoList.add(cityDto1);
    cityDtoList.add(cityDto2);

    String result = JsonConverter.writer("cityFilter", cityDtoList, include);
    if (result == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
