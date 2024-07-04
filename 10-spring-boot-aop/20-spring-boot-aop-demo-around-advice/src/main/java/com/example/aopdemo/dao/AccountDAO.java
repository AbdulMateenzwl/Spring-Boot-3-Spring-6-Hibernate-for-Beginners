package com.example.aopdemo.dao;

import java.util.List;

import com.example.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, Boolean vipFlag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
