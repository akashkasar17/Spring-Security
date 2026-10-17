package com.security.global.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<String> handle415Error(HttpMediaTypeNotSupportedException ex) {
        return new ResponseEntity<>("Method Not Allowed: Unsupported Media Type", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
	
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handle405Error(HttpRequestMethodNotSupportedException ex) {
        return new ResponseEntity<>("Method Not Allowed: " + ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    // Handle 400 Bad Request when invalid input is provided
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException ex) {
        String errorMessage = "Constraint violation: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    // Handle other types of 400 errors, like malformed JSON
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidRequest(HttpMessageNotReadableException ex) {
        String errorMessage = "Malformed request: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle500Error(Exception ex) {
        String errorMessage = "Internal server error occurred. Please try again later.";
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
