package com.example.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);

			// findInstructorById(appDAO);
		
			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail with id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		
		// get the istructor detaial object
		int theId = 1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print instructor details
		System.out.println("Instructor Detail: " + tempInstructorDetail);

		// pring the associated instructor
		System.out.println("Instructor : " + tempInstructorDetail.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor with id: " + theId);

		appDAO.deleteInstructor(theId);

		System.out.println("Done");
	}

	private void findInstructorById(AppDAO appDAO) {
		int theId =2;

		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Instructor: " + tempInstructor);
		System.out.println("Instructor Details: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// // create the instructor
		// Instructor tempInstructor = new Instructor("Abdul","Mateen","abdulmateen@duck.com");
		// InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/abdulmateenzwl","code!!!");

		// create the instructor
		Instructor tempInstructor = new Instructor("user2","2","user2@mail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/y","test");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);


		// save the instructor
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}
}
