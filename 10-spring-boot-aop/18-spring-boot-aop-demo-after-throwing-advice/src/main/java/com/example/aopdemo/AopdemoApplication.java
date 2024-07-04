package com.example.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

			// demoTheAfterReturningAdvice(theAccountDAO, theMembershipDAO);

			demoTheAfterThrowingAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// call the accountdao findAccounts method
		List<Account> myAccounts = null;
		try {
			boolean tripWire = true;
			myAccounts = theAccountDAO.findAccounts(tripWire);
			
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

		// display the accoutns 
		System.out.println("\n\nMain Program: AfterThrowingAdvise");
		System.out.println("----");

		System.out.println(myAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		// call the accountdao findAccounts method
		List<Account> myAccounts = theAccountDAO.findAccounts();

		// display the accoutns 
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");

		System.out.println(myAccounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		Account myAccount = new Account();
		myAccount.setLevel("level");
		myAccount.setName("name");

		// call the account method
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao geter/ setter
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();

		// call the membership buisness method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}
