package com.example.demo.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FunRestController {

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