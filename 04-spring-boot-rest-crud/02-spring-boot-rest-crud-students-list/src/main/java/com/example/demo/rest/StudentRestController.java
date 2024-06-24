package com.example.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitiy.Student;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentRestController {
    
    // define endpoint for student 

    @GetMapping("/students")
    public List<Student> getStudent() {

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Doe"));
        theStudents.add(new Student("Abdul", "Mateen"));
        return theStudents;
    }
    
}
