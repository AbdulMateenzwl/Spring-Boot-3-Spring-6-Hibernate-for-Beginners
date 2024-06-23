package com.example.demo.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FunRestController {

    // Inject Property for coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team name: " + teamName;
    }



    @GetMapping("/")
    public String sayHello() {
        return "hello World ";
    }

    @GetMapping("/workout")
    public String getDailyWorkoutString() {
        return new String("Run a hard 5k");
    }
    
    @GetMapping("/fortune")
    public String getFortune() {
        return new String("Today is your lucky day!");
    }
    
}