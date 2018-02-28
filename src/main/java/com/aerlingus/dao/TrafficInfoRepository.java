package com.aerlingus.dao;

import com.aerlingus.dto.AirportInfoDto;
import com.aerlingus.dto.TrafficInfoDto;
import com.aerlingus.entity.TrafficInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TrafficInfoRepository extends CrudRepository<TrafficInfo, String> {
  @Query("SELECT new com.aerlingus.dto.TrafficInfoDto(t.originAirport,t.destAirport, COUNT(t.destAirport)) " +
      "FROM TrafficInfo t WHERE t.transactionDate BETWEEN :startDate AND :endDate GROUP BY t.destAirport,t.originAirport")
  public List<TrafficInfoDto> getTrafficInfoDtoList(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

  @Query("SELECT new com.aerlingus.dto.AirportInfoDto(t.originAirport, COUNT(t.originAirport)) " +
      "FROM TrafficInfo t WHERE t.transactionDate BETWEEN :startDate AND :endDate GROUP BY t.originAirport")
  public List<AirportInfoDto> getAirportInfos(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

  @Query("SELECT new com.aerlingus.dto.AirportInfoDto(t.originAirport, COUNT(t.originAirport)) FROM TrafficInfo t WHERE t.transactionDate BETWEEN :startDate AND :endDate " +
      "GROUP BY t.originAirport HAVING t.originAirport=:airportCode")
  public List<AirportInfoDto> getAirportInfo(@Param("airportCode") String airportCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
