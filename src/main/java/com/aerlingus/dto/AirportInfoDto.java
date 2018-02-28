package com.aerlingus.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

public class AirportInfoDto {
  private String originAirport;
  private long totalNumber;
  private String startDate;
  private String endDate;
  private List<DestinationDto> destinations = new ArrayList<>();

  public AirportInfoDto() {
  }

  public AirportInfoDto(String originAirport, long totalNumber) {
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

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public List<DestinationDto> getDestinations() {
    return destinations;
  }

  public void setDestinations(List<DestinationDto> destinations) {
    this.destinations = destinations;
  }
}
