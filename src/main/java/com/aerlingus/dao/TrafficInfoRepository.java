package com.aerlingus.dao;

import com.aerlingus.entity.TrafficInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficInfoRepository extends CrudRepository<TrafficInfo,String>{
}
