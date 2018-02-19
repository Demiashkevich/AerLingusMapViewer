package com.aerlingus.service;

import com.aerlingus.dao.TrafficInfoRepository;
import com.aerlingus.dto.CityInfo;
import com.aerlingus.dto.TrafficInfoDto;
import com.aerlingus.entity.TrafficInfo;
import com.aerlingus.parser.FileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrafficInfoService {
  @Autowired
  TrafficInfoRepository trafficInfoRepository;
  @Autowired
  FileParser fileParser;

  public void addTrafficInfo(){
    List<String> pathList=new ArrayList<>();
    pathList.add("C:/Users/Jan_Zharov/IdeaProjects/AerLingusMapViewer/src/main/java/com/aerlingus/info.csv");
    List<TrafficInfo> trafficInfos=fileParser.parse(pathList);
    trafficInfoRepository.save(trafficInfos);
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
