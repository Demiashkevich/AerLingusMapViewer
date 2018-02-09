package com.aerlingus.converter;

import com.aerlingus.filter.CityFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import org.apache.log4j.Logger;

import java.util.Objects;

public final class JsonConverter {

  private static final Logger logger = Logger.getLogger(JsonConverter.class);

  private static ObjectMapper mapper = new ObjectMapper();
  private static ObjectWriter writer;

  public static String writer(final String filterName, final Object o, final String[] include) {
    FilterProvider provider;
    if (Objects.isNull(include)) {
      provider = CityFilter.buildFilter(filterName, false, null);
    } else {
      provider = CityFilter.buildFilter(filterName, true, include);
    }
    writer = mapper.writer(provider);
    return writeValueAsString(o);
  }

  private static String writeValueAsString(final Object o) {
    try {
      return writer.writeValueAsString(o);
    } catch (JsonProcessingException e) {
      logger.error("Unable write " + o.getClass().getTypeName() + " to JSON", e);
    }
    return null;
  }

}
