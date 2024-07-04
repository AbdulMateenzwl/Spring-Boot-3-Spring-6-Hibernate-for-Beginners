package com.example.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    // this is where we add all of ou related advices for logging

    // lets's start with an @Before advice

    @Before("com.example.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>> Executing @Before advice");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSig);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void AfterReturningFindAccountsAdvice(JoinPoint theJoinPoint , List<Account> result) {
        // print out which method we are advising on 
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @AfterReturning on method: " + method);

        /// print out the results of the method call
        System.out.println("\n=====>> result is: " + result);
    }

}
