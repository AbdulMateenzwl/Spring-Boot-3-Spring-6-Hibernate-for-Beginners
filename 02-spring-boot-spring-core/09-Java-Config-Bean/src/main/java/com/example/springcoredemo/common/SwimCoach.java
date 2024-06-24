package com.example.springcoredemo.common;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("SwimCoach: inside no-arg constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up!!!";
    }

}
