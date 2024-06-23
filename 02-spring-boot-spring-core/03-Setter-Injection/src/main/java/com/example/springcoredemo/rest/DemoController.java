package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcoredemo.common.Coach;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkoutString() {
        return myCoach.getDailyWorkout();
    }
}
