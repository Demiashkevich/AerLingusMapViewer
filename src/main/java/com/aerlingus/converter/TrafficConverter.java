package com.aerlingus.converter;

import com.aerlingus.dto.CityInfoDto;
import com.aerlingus.dto.DestinationDto;
import com.aerlingus.dto.TrafficInfoDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrafficConverter {

  public List<CityInfoDto> trafficDtoToCityDto(final List<CityInfoDto> cityDtoList, final List<TrafficInfoDto> trafficDtoList){
    final List<CityInfoDto> result = new ArrayList<>();
    cityDtoList.forEach(c -> {
      final CityInfoDto cityDto = new CityInfoDto();
      cityDto.setOriginCity(c.getOriginCity());
      trafficDtoList.forEach(t -> {
        if (t.getOriginCity().equals(c.getOriginCity())) {
          DestinationDto destinationDto = new DestinationDto(
              t.getDestCity(),
              t.getTotalNumber()
          );
          cityDto.getDestinations().add(destinationDto);
        }
      });
      result.add(cityDto);
    });
  return result;
  }

}
