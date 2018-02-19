package com.aerlingus.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

public class CityInfoDto {
  private String originAirport;
  private long totalNumber;
  private List<DestinationDto> destinations = new ArrayList<>();

  public CityInfoDto() {
  }

  public CityInfoDto(String originAirport, long totalNumber) {
    this.originAirport = originAirport;
    this.totalNumber = totalNumber;
  }

  public String getOriginAirport() {
    return originAirport;
  }

  public void setOriginAirport(String originAirport) {
    this.originAirport = originAirport;
  }

  public long getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(long totalNumber) {
    this.totalNumber = totalNumber;
  }

  public List<DestinationDto> getDestinations() {
    return destinations;
  }

  public void setDestinations(List<DestinationDto> destinations) {
    this.destinations = destinations;
  }
}
