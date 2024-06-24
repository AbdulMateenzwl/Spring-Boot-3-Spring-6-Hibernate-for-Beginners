package com.example.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitiy.Student;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api")
public class StudentRestController {
    
    // define endpoint for student 
    private List<Student> theStudents;

    @PostConstruct
    public void LoadData(){theStudents = new ArrayList<>();
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Doe"));
        theStudents.add(new Student("Abdul", "Mateen"));
    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return theStudents;
    }
    
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if(studentId >= theStudents.size() || studentId < 0)
            throw new StudentNotFoundException("Student id not found - " + studentId);
        
        return theStudents.get(studentId);
    }


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
