package com.aerlingus.dto;

import java.io.Serializable;

public class DestinationDto implements Serializable {

  private static long serialVersionUID = 3L;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DestinationDto that = (DestinationDto) o;

    if (totalNumber != that.totalNumber) return false;
    return destAirport != null ? destAirport.equals(that.destAirport) : that.destAirport == null;
  }

  @Override
  public int hashCode() {
    int result = destAirport != null ? destAirport.hashCode() : 0;
    result = 31 * result + (int) (totalNumber ^ (totalNumber >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "DestinationDto{" +
        "destAirport='" + destAirport + '\'' +
        ", totalNumber=" + totalNumber +
        '}';
  }
}
