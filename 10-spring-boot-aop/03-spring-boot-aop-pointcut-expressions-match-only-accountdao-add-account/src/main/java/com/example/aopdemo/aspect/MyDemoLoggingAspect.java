package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    
    // this is where we add all of ou related advices for logging

    // lets's start with an @Before advice
    
    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>> Executing @Before advice on addAccount()");
    }
}
