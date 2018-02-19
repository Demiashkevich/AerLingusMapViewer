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
  @Query("SELECT new com.aerlingus.dto.TrafficInfoDto(t.originCity,t.destCity, COUNT(t.destCity)) " +
      "FROM TrafficInfo t GROUP BY t.destCity,t.originCity " +
      "HAVING t.originCity IN (SELECT ti.originCity FROM TrafficInfo ti GROUP BY ti.originCity)")
  public List<TrafficInfoDto> getTrafficInfoDtoList();
  @Query("SELECT new com.aerlingus.dto.TrafficInfoDto(t.originCity,t.destCity, COUNT(t.destCity)) " +
      "FROM TrafficInfo t GROUP BY t.destCity,t.originCity " +
      "HAVING t.originCity=:city")
  public List<TrafficInfoDto> getTrafficInfoDto(@Param("city") String city);
  @Query("SELECT new com.aerlingus.dto.CityInfoDto(t.originCity, COUNT(t.originCity)) FROM TrafficInfo t GROUP BY t.originCity")
  public List<CityInfoDto> getCityInfos();
  @Query("SELECT new com.aerlingus.dto.CityInfoDto(t.originCity, COUNT(t.originCity)) FROM TrafficInfo t GROUP BY t.originCity HAVING t.originCity=:city")
  public CityInfoDto getCityInfo(@Param("city") String city);
}
