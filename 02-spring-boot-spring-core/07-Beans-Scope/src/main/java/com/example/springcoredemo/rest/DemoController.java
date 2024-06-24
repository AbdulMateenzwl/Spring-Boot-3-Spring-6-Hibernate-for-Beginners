package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcoredemo.common.Coach;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    private Coach myCoach;

    private Coach anotherCoach;

    @Autowired
    public DemoController( 
        @Qualifier("cricketCoach") Coach theCoach,
        @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("DemoController: inside constructor");
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkoutString() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing Beans: myCoach == anotherCoach: " + (myCoach == anotherCoach);
    }
    
}
