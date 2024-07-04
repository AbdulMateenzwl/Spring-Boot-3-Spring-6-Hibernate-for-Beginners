package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    
    @Override
    public void addAccount(){
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
    }

    @Override
    public Boolean addSillyMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A SILLY MEMBERSHIP ACCOUNT");
        return true;
    }

    @Override
    public void goToSleep() {
        
        System.out.println(getClass() + ": I'm going to sleep now...");
    }


}
