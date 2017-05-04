package com.test.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * Custom Exception Handler for HTTP Response
 *
 * @author mganes004c
 * @since 2017-01-26
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @Autowired
    private Tracer tracer;

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ExceptionResponse> handleDefaultError(Exception ex, HttpServletRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("ERR-01", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
                request.getRequestURI(), Instant.now().toEpochMilli());
        reportErrorSpan(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void reportErrorSpan(String message) {
        if(tracer != null) {
            Span span = tracer.getCurrentSpan();
            span.logEvent("ERROR: " + message);
            tracer.addTag("error", message);
        }
    }

}
