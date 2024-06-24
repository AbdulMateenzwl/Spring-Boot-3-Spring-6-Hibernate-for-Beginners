package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    
    // add exception handling code here

    // Add an ecxeption handler using @exceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorController> handleException(StudentNotFoundException exc) {

        // create a StudentErrorResponse
        StudentErrorController error = new StudentErrorController();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return Response Entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    // add another exception handler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorController> handleException(Exception exc) {

        // create a StudentErrorResponse
        StudentErrorController error = new StudentErrorController();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return Response Entity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
