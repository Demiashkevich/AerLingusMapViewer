package com.aerlingus.dto;

public class DestinationDto {
  private String destAirport;
  private long totalNumber;

  public DestinationDto() {
  }

  public DestinationDto(String destAirport, long totalNumber) {
    this.destAirport = destAirport;
    this.totalNumber = totalNumber;
  }

  public String getDestAirport() {
    return destAirport;
  }

  public void setDestAirport(String destAirport) {
    this.destAirport = destAirport;
  }

  public long getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(long totalNumber) {
    this.totalNumber = totalNumber;
  }
}
