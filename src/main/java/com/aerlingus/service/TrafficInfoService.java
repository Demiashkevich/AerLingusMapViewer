package com.aerlingus.service;

import com.aerlingus.dao.TrafficInfoRepository;
import com.aerlingus.dto.CityInfo;
import com.aerlingus.dto.TrafficInfoDto;
import com.aerlingus.entity.TrafficInfo;
import com.aerlingus.parser.FileParser;
import com.aerlingus.parser.PathScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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

  public String getTrafficInfo(){
    Iterable<CityInfo> cityInfos=trafficInfoRepository.getCityInfos();
    Iterable<TrafficInfoDto> trafficInfoDtoList=trafficInfoRepository.getTrafficInfoDtoList();
    buildCityInfoList(cityInfos,trafficInfoDtoList);
    return cityInfos.toString();
  }

  public List<CityInfo> buildCityInfoList(Iterable<CityInfo> cityInfos, Iterable<TrafficInfoDto> trafficInfoDtoList){

    return null;
  }
}
