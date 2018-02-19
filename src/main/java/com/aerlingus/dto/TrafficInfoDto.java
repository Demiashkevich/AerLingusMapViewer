package com.aerlingus.dto;

public class TrafficInfoDto {
  private String originAirport;
  private String destAirport;
  private long totalNumber;

  public TrafficInfoDto() {
  }

  public TrafficInfoDto(String originAirport, String destAirport, long totalNumber) {
    this.originAirport = originAirport;
    this.destAirport = destAirport;
    this.totalNumber = totalNumber;
  }

  public String getOriginAirport() {
    return originAirport;
  }

  public void setOriginAirport(String originAirport) {
    this.originAirport = originAirport;
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
