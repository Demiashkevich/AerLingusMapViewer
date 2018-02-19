package com.aerlingus.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAFFIC_INFO")
public class TrafficInfo {
  private static long serialVersionUID=1L;
  @Id
  @Column(name="PNR_REFERENCE")
  private String PnrReference;
  @Column(name="TRANSACTION_ID")
  private String transactionId;
  @Column(name="ORIGIN_CITY")
  private String originCity;
  @Column(name="DEST_CITY")
  private String destCity;
  @Column(name="TRANSACTION_DATE")
  private Date transactionDate;
  @Column(name="QUANTITY")
  private String quantity;

  public TrafficInfo() {
  }

  public TrafficInfo(String pnrReference, String transactionId, String originCity, String destCity, Date transactionDate,
      String quantity) {
    PnrReference = pnrReference;
    this.transactionId = transactionId;
    this.originCity = originCity;
    this.destCity = destCity;
    this.transactionDate = transactionDate;
    this.quantity = quantity;
  }

  public String getPnrReference() {
    return PnrReference;
  }

  public void setPnrReference(String pnrReference) {
    PnrReference = pnrReference;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
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

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TrafficInfo that = (TrafficInfo) o;

    if (PnrReference != null ? !PnrReference.equals(that.PnrReference) : that.PnrReference != null) return false;
    if (transactionId != null ? !transactionId.equals(that.transactionId) : that.transactionId != null) return false;
    if (originCity != null ? !originCity.equals(that.originCity) : that.originCity != null) return false;
    if (destCity != null ? !destCity.equals(that.destCity) : that.destCity != null) return false;
    if (transactionDate != null ? !transactionDate.equals(that.transactionDate) : that.transactionDate != null) return false;
    return quantity != null ? quantity.equals(that.quantity) : that.quantity == null;
  }

  @Override
  public int hashCode() {
    int result = PnrReference != null ? PnrReference.hashCode() : 0;
    result = 31 * result + (transactionId != null ? transactionId.hashCode() : 0);
    result = 31 * result + (originCity != null ? originCity.hashCode() : 0);
    result = 31 * result + (destCity != null ? destCity.hashCode() : 0);
    result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
    result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TrafficInfo{" +
        "PnrReference='" + PnrReference + '\'' +
        ", transactionId='" + transactionId + '\'' +
        ", originCity='" + originCity + '\'' +
        ", destCity='" + destCity + '\'' +
        ", transactionDate=" + transactionDate +
        ", quantity='" + quantity + '\'' +
        '}';
  }
}
