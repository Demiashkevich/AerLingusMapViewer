package com.aerlingus.service;

import com.aerlingus.dao.TrafficInfoRepository;
import com.aerlingus.entity.TrafficInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TrafficInfoService {
  @Autowired
  TrafficInfoRepository trafficInfoRepository;

  public void addTrafficInfo(){
    trafficInfoRepository.save(new TrafficInfo("RH4J2N", "1", "1", "1", new Date(),"1"));
  }
}
