package com.aerlingus.dto;

public class TrafficInfoDto {
  private String originCity;
  private String destCity;
  private long totalNumber;

  public TrafficInfoDto() {
  }

  public TrafficInfoDto(String originCity, String destCity, long totalNumber) {
    this.originCity = originCity;
    this.destCity = destCity;
    this.totalNumber = totalNumber;
  }

  public String getOriginCity() {
    return originCity;
  }

  public void setOriginCity(String originCity) {
    this.originCity = originCity;
  }

  public String getDestCity() {
    return destCity;
  }

  public void setDestCity(String destCity) {
    this.destCity = destCity;
  }

  public long getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(long totalNumber) {
    this.totalNumber = totalNumber;
  }
}
