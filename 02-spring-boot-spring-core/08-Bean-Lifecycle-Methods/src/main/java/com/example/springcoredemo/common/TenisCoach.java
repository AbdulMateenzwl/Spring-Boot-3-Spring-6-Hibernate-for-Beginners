package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach{
    public TenisCoach(){
        System.out.println("TennisCoach: inside no-arg constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
