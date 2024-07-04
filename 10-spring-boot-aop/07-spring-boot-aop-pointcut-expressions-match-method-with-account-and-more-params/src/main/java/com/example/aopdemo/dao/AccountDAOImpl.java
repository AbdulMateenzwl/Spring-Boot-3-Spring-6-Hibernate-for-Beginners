package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.example.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account theAccount, Boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
        
    }

}
