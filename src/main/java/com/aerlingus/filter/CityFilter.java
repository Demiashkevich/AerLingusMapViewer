package com.aerlingus.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Arrays;
import java.util.HashSet;

public final class CityFilter {

  public static FilterProvider buildFilter(final String filterName, final boolean failOnUnknownId, final String... propertiesExcept) {
    SimpleFilterProvider filterProvider = new SimpleFilterProvider();
    if (!failOnUnknownId) {
      filterProvider.setFailOnUnknownId(false);
      return filterProvider;
    }
    final SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(new HashSet<>(Arrays.asList(propertiesExcept)));
    return filterProvider.addFilter(filterName, filter);
  }

}
