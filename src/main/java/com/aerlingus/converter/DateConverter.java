package com.aerlingus.converter;

import com.aerlingus.parser.FileParser;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
  private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
  private static final Logger logger = Logger.getLogger(DateConverter.class);

  public static Date convertStringToDate(final String strDate){
    try {
      return formatter.parse(strDate);
    } catch (ParseException e) {
      logger.error("Unable to convert the string (" + strDate + ") to date");
    }
    return null;
  }
}
