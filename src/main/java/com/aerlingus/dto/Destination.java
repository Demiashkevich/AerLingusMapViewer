package com.aerlingus.dto;

public class Destination {
  private String destCity;
  private int totalNumber;

  public Destination() {
  }

  public Destination(String destCity, int totalNumber) {
    this.destCity = destCity;
    this.totalNumber = totalNumber;
  }

  public String getDestCity() {
    return destCity;
  }

  public void setDestCity(String destCity) {
    this.destCity = destCity;
  }

  public int getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(int totalNumber) {
    this.totalNumber = totalNumber;
  }
}
