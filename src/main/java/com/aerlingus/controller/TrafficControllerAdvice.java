package com.aerlingus.controller;

import com.aerlingus.entity.ErrorDetails;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@RestController
public class TrafficControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler({
      BindException.class,
      MethodArgumentNotValidException.class,
      HttpMessageNotReadableException.class,
      MissingServletRequestPartException.class,
      TypeMismatchException.class
  })
  protected ResponseEntity<ErrorDetails> handleBadRequest(Exception ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), "Bad Request",
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({
      ConversionNotSupportedException.class,
      HttpMessageNotWritableException.class
  })
  protected ResponseEntity<ErrorDetails> handleInternalServerError(Exception ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), "Internal Server Error",
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
