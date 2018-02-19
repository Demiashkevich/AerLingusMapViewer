package com.aerlingus.dao;

import com.aerlingus.dto.CityInfoDto;
import com.aerlingus.dto.TrafficInfoDto;
import com.aerlingus.entity.TrafficInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrafficInfoRepository extends CrudRepository<TrafficInfo, String> {
  @Query("SELECT new com.aerlingus.dto.TrafficInfoDto(t.originAirport,t.destAirport, COUNT(t.destAirport)) " +
      "FROM TrafficInfo t GROUP BY t.destAirport,t.originAirport " +
      "HAVING t.originAirport IN (SELECT ti.originAirport FROM TrafficInfo ti GROUP BY ti.originAirport)")
  public List<TrafficInfoDto> getTrafficInfoDtoList();
  @Query("SELECT new com.aerlingus.dto.TrafficInfoDto(t.originAirport,t.destAirport, COUNT(t.destAirport)) " +
      "FROM TrafficInfo t GROUP BY t.destAirport,t.originAirport " +
      "HAVING t.originAirport=:city")
  public List<TrafficInfoDto> getTrafficInfoDto(@Param("city") String city);
  @Query("SELECT new com.aerlingus.dto.CityInfoDto(t.originAirport, COUNT(t.originAirport)) FROM TrafficInfo t GROUP BY t.originAirport")
  public List<CityInfoDto> getCityInfos();
  @Query("SELECT new com.aerlingus.dto.CityInfoDto(t.originAirport, COUNT(t.originAirport)) FROM TrafficInfo t GROUP BY t.originAirport HAVING t.originAirport=:city")
  public CityInfoDto getCityInfo(@Param("city") String city);
}
