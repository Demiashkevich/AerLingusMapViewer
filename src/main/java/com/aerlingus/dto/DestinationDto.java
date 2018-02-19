package com.aerlingus.dto;

public class DestinationDto {
  private String destCity;
  private long totalNumber;

  public DestinationDto() {
  }

  public DestinationDto(String destCity, long totalNumber) {
    this.destCity = destCity;
    this.totalNumber = totalNumber;
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

  public void setTotalNumber(int totalNumber) {
    this.totalNumber = totalNumber;
  }
}
