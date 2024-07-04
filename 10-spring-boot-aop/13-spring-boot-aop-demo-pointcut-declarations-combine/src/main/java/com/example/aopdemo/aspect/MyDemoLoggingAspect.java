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

    // create a pointcut forr getter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    private void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    private void setter(){}


    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {

    }
    
    // lets's start with an @Before advice

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>> Executing @Before advice");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>> Performing API analytics");
    }
}
