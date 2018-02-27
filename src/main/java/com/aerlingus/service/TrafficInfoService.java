package com.aerlingus.service;

import com.aerlingus.converter.TrafficConverter;
import com.aerlingus.dao.TrafficInfoRepository;
import com.aerlingus.dto.AirportInfoDto;
import com.aerlingus.dto.TrafficInfoDto;
import com.aerlingus.entity.TrafficInfo;
import com.aerlingus.parser.FileParser;
import com.aerlingus.parser.PathScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Properties;

@Service
public class TrafficInfoService {

  @Autowired
  private TrafficInfoRepository trafficInfoRepository;

  @Autowired
  private FileParser fileParser;

  @Autowired
  private PathScanner pathScanner;

  @Autowired
  private Properties appProperties;

  @Autowired
  private TrafficConverter trafficConverter;

  public boolean addTrafficInfo(){
    final List<String> pathList = pathScanner.scannerPackage(appProperties.getProperty("scanner.package"));
    if (CollectionUtils.isEmpty(pathList)) {
      return false;
    }
    final List<TrafficInfo> trafficList = fileParser.parse(pathList);
    if (CollectionUtils.isEmpty(trafficList)) {
      return false;
    }
    trafficInfoRepository.save(trafficList);
    return true;
  }

  public List<AirportInfoDto> getAirportInfos() {
    final List<AirportInfoDto> airportInfoDtoList = trafficInfoRepository.getAirportInfos();
    final List<TrafficInfoDto> trafficDtoList = trafficInfoRepository.getTrafficInfoDtoList();

    trafficConverter.trafficDtoToCityDto(airportInfoDtoList, trafficDtoList);

    return airportInfoDtoList;
  }

  public AirportInfoDto getAirportInfo(String airportCode) {
    final List<AirportInfoDto> airportInfoDtoList = trafficInfoRepository.getAirportInfo(airportCode);
    final List<TrafficInfoDto> trafficDtoList = trafficInfoRepository.getTrafficInfoDtoList();

    trafficConverter.trafficDtoToCityDto(airportInfoDtoList, trafficDtoList);
    if(!airportInfoDtoList.isEmpty()){
      return airportInfoDtoList.get(0);
    }
    return null;
  }
}
