package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    public TrackCoach(){
        System.out.println("TrackCoach: inside no-arg constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
