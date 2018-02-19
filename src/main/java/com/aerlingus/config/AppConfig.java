package com.aerlingus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration
@PropertySource("application-conf.properties")
public class AppConfig {

  @Autowired
  private Environment env;

  @Bean
  public Properties appProperties() {
    final Properties properties = new Properties();
    properties.setProperty("scanner.package", env.getProperty("scanner.package"));
    return properties;
  }

}
