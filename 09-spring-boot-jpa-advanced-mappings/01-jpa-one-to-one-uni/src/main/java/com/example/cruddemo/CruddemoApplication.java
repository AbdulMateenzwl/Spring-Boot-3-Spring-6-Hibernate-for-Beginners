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
			createInstructor(appDAO);
		};
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
