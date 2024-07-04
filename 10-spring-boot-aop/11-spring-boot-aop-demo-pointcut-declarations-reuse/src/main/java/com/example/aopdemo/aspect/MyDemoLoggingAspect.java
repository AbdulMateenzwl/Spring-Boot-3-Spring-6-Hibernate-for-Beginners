package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of ou related advices for logging

    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {

    }
    
    // lets's start with an @Before advice

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>> Executing @Before advice");
    }
}
