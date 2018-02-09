package com.aerlingus.dto;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("cityFilter")
public class CityDto {

  private String name;
  private Double locationX;
  private Double locationY;
  private Integer bookingCount;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getLocationX() {
    return locationX;
  }

  public void setLocationX(Double locationX) {
    this.locationX = locationX;
  }

  public Double getLocationY() {
    return locationY;
  }

  public void setLocationY(Double locationY) {
    this.locationY = locationY;
  }

  public Integer getBookingCount() {
    return bookingCount;
  }

  public void setBookingCount(Integer bookingCount) {
    this.bookingCount = bookingCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CityDto cityDto = (CityDto) o;

    return name.equals(cityDto.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

}
