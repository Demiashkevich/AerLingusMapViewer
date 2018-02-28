package com.aerlingus.util;

import com.aerlingus.dto.AirportInfoDto;

import java.util.Date;
import java.util.List;

public class DateSetter {
  public static void setResponseDate(List<AirportInfoDto> airportInfoDtoList, String startDate, String endDate){
    for(AirportInfoDto airportInfoDto:airportInfoDtoList){
      airportInfoDto.setStartDate(startDate);
      airportInfoDto.setEndDate(endDate);
    }
  }
}
