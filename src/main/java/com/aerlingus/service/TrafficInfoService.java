package com.aerlingus.service;

import com.aerlingus.converter.DateConverter;
import com.aerlingus.converter.TrafficConverter;
import com.aerlingus.dao.TrafficInfoRepository;
import com.aerlingus.dto.AirportInfoDto;
import com.aerlingus.dto.TrafficInfoDto;
import com.aerlingus.entity.TrafficInfo;
import com.aerlingus.parser.FileParser;
import com.aerlingus.parser.PathScanner;
import com.aerlingus.util.DateSetter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class TrafficInfoService {
  private static final Logger logger = Logger.getLogger(TrafficInfoService.class);

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

  public List<AirportInfoDto> getAirportInfos(String startDateStr,String endDateStr) {
    Date startDate=DateConverter.convertStringToDate(startDateStr);
    Date endDate=DateConverter.convertStringToDate(endDateStr);
    if(startDate==null || endDate==null){
      logger.error("Wrong date startDate="+startDate+" endDate="+endDate);
      return null;
    }

    final List<AirportInfoDto> airportInfoDtoList = trafficInfoRepository.getAirportInfos(startDate,endDate);
    final List<TrafficInfoDto> trafficDtoList = trafficInfoRepository.getTrafficInfoDtoList(startDate,endDate);

    trafficConverter.trafficDtoToCityDto(airportInfoDtoList, trafficDtoList);
    DateSetter.setResponseDate(airportInfoDtoList,startDateStr,endDateStr);
    return airportInfoDtoList;
  }

  public AirportInfoDto getAirportInfo(String airportCode, String startDateStr,String endDateStr) {
    Date startDate=DateConverter.convertStringToDate(startDateStr);
    Date endDate=DateConverter.convertStringToDate(endDateStr);
    if(startDate==null || endDate==null){
      logger.error("Wrong date startDate="+startDate+" endDate="+endDate);
      return null;
    }

    final List<AirportInfoDto> airportInfoDtoList = trafficInfoRepository.getAirportInfo(airportCode, startDate, endDate);
    final List<TrafficInfoDto> trafficDtoList = trafficInfoRepository.getTrafficInfoDtoList(startDate,endDate);

    trafficConverter.trafficDtoToCityDto(airportInfoDtoList, trafficDtoList);
    DateSetter.setResponseDate(airportInfoDtoList,startDateStr,endDateStr);
    if(!airportInfoDtoList.isEmpty()){
      return airportInfoDtoList.get(0);
    }
    return null;
  }
}
