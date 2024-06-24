package com.example.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitiy.Student;

import jakarta.annotation.PostConstruct;

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


    
}
