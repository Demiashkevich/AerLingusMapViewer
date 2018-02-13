package com.aerlingus.parser;

import com.aerlingus.entity.TrafficInfo;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileParser {

  private static final Logger logger = Logger.getLogger(FileParser.class);

  public List<TrafficInfo> parse(final List<String> pathList) {
    final List<TrafficInfo> allFileResult = new ArrayList<>();
    pathList.forEach(p -> {
      final List<TrafficInfo> fileResult = this.parse(p);
      allFileResult.addAll(fileResult);
    });
    return allFileResult;
  }

  private List<TrafficInfo> parse(final String path) {
    final List<String> fileLineList = this.getFileLine(path);

    List<String> subFileLineList = fileLineList.subList(7, fileLineList.size());

    final List<TrafficInfo> trafficInfoList = new ArrayList<>();

    subFileLineList.forEach(s -> {
      final List<String> valueLineList = Splitter.on(CharMatcher.anyOf("|,")).splitToList(s);

      final TrafficInfo trafficInfo = new TrafficInfo();
      trafficInfo.setPnrReference(valueLineList.get(0));
      trafficInfo.setTransactionId(valueLineList.get(1));
      trafficInfo.setOriginAirport(valueLineList.get(2));
      trafficInfo.setDestAirport(valueLineList.get(3));
      trafficInfo.setTransactionDate(parseDate(valueLineList.get(4)));
      trafficInfo.setQuantity(valueLineList.get(5));

      trafficInfoList.add(trafficInfo);
    });

    return trafficInfoList;
  }

  private Date parseDate(final String formatDate) {
    final String strDate = Splitter.on(".").splitToList(formatDate).get(0);
    return this.convertStringToDate(strDate);
  }

  private Date convertStringToDate(final String strDate) {
    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    try {
      return formatter.parse(strDate);
    } catch (ParseException e) {
      logger.error("Unable to convert the string (" + strDate + ") to date");
    }
    return null;
  }

  private List<String> getFileLine(final String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      logger.error("Unable read file by path: " + path);
      throw new RuntimeException(e);
    }
  }

}
