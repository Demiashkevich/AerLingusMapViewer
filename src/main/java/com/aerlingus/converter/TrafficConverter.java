package com.aerlingus.converter;

import com.aerlingus.dto.CityInfoDto;
import com.aerlingus.dto.DestinationDto;
import com.aerlingus.dto.TrafficInfoDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrafficConverter {

  public void trafficDtoToCityDto(final List<CityInfoDto> cityDtoList, final List<TrafficInfoDto> trafficDtoList){
    cityDtoList.forEach(c -> {
      trafficDtoList.forEach(t -> {
        if (t.getOriginAirport().equals(c.getOriginAirport())) {
          DestinationDto destinationDto = new DestinationDto(
              t.getDestAirport(),
              t.getTotalNumber()
          );
          c.getDestinations().add(destinationDto);
        }
      });
    });
  }

}
