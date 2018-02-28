package com.aerlingus.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

public class AirportInfoDto implements Serializable {

  private static long serialVersionUID = 2L;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AirportInfoDto that = (AirportInfoDto) o;

    if (totalNumber != that.totalNumber) return false;
    if (originAirport != null ? !originAirport.equals(that.originAirport) : that.originAirport != null) return false;
    if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
    if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
    return destinations != null ? destinations.equals(that.destinations) : that.destinations == null;
  }

  @Override
  public int hashCode() {
    int result = originAirport != null ? originAirport.hashCode() : 0;
    result = 31 * result + (int) (totalNumber ^ (totalNumber >>> 32));
    result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
    result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
    result = 31 * result + (destinations != null ? destinations.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AirportInfoDto{" +
        "originAirport='" + originAirport + '\'' +
        ", totalNumber=" + totalNumber +
        ", startDate='" + startDate + '\'' +
        ", endDate='" + endDate + '\'' +
        ", destinations=" + destinations +
        '}';
  }

}
