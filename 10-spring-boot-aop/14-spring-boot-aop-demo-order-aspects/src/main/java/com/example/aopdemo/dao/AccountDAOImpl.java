package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.example.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account theAccount, Boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
        
    }

    @Override
    public boolean doWork() {
        
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {

        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }

    
}
