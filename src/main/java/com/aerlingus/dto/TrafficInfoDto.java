package com.aerlingus.dto;

import java.io.Serializable;

public class TrafficInfoDto implements Serializable {

  private static long serialVersionUID = 4L;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TrafficInfoDto that = (TrafficInfoDto) o;

    if (totalNumber != that.totalNumber) return false;
    if (originAirport != null ? !originAirport.equals(that.originAirport) : that.originAirport != null) return false;
    return destAirport != null ? destAirport.equals(that.destAirport) : that.destAirport == null;
  }

  @Override
  public int hashCode() {
    int result = originAirport != null ? originAirport.hashCode() : 0;
    result = 31 * result + (destAirport != null ? destAirport.hashCode() : 0);
    result = 31 * result + (int) (totalNumber ^ (totalNumber >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "TrafficInfoDto{" +
        "originAirport='" + originAirport + '\'' +
        ", destAirport='" + destAirport + '\'' +
        ", totalNumber=" + totalNumber +
        '}';
  }
}
