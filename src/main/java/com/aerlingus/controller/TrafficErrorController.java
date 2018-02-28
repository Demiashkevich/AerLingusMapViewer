package com.aerlingus.controller;

import com.aerlingus.entity.ErrorDetails;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TrafficErrorController implements ErrorController {

  private static final String PATH = "/error";


  @RequestMapping(value = PATH)
  public ResponseEntity<ErrorDetails> error(HttpServletRequest request, HttpServletResponse response) {
    if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
      return new ResponseEntity<>(new ErrorDetails(LocalDate.now(), "No web page find by this url", null), HttpStatus.BAD_REQUEST);
    }
    if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
      return new ResponseEntity<>(new ErrorDetails(LocalDate.now(), "Unable get traffic info by this airport. Try it later.", null), HttpStatus.BAD_REQUEST);
    }
    return null;
  }

  @Override
  public String getErrorPath() {
    return PATH;
  }

}
