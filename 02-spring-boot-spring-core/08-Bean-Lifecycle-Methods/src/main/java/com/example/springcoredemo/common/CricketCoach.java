package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    @PostConstruct // Do startup stuff
    public void doMyStartupStuff(){
        System.out.println(getClass().getSimpleName() + ": inside doMyStartupStuff");
    }

    @PreDestroy // Do destroy stuff
    public void doMyCleanUpStuff(){
        System.out.println(getClass().getSimpleName() + ": inside doMyCleanUpStuff");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }
}
