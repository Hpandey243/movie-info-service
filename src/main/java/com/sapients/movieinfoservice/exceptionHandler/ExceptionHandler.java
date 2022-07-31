package com.sapients.movieinfoservice.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleException(NotFoundException ex) {
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = MicroserviceException.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}