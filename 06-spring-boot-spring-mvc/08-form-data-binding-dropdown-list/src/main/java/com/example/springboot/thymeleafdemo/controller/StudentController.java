package com.example.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.springboot.thymeleafdemo.model.Student;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("showStudentForm")
    public String showForm(Model theModel) {

        // create a student object
        Student theStudent = new Student();

        // add student object to the model
        theModel.addAttribute("student", theStudent);

        theModel.addAttribute("countries",countries);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processFormString(@ModelAttribute("student") Student theStudent) {

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName()
                + " " + theStudent.getLastName());

        return "student-confirmation";
    }

}
