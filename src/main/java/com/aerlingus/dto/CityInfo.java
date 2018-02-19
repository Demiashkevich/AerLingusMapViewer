package com.aerlingus.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

public class CityInfo {
  private String originCity;
  private long totalNumber;
  private List<Destination> destinations;

  public CityInfo() {
  }

  public CityInfo(String originCity, long totalNumber) {
    this.originCity = originCity;
    this.totalNumber = totalNumber;
  }

  public String getOriginCity() {
    return originCity;
  }

  public void setOriginCity(String originCity) {
    this.originCity = originCity;
  }

  public long getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(long totalNumber) {
    this.totalNumber = totalNumber;
  }

  public List<Destination> getDestinations() {
    return destinations;
  }

  public void setDestinations(List<Destination> destinations) {
    this.destinations = destinations;
  }
}
