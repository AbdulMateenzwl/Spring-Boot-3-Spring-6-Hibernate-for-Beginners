package com.example.aopdemo.dao;

import com.example.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, Boolean vipFlag);
    
    boolean doWork();
}
