package com.example.demo.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "hello World 1";
    }
    
}