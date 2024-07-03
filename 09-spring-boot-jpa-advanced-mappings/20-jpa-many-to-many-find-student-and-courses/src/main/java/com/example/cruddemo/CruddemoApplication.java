package com.example.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import com.example.cruddemo.entity.Review;
import com.example.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {

			// createCourseAndStudent(appDAO);

			// findCourseAndStudent(appDAO);

			findStudentAndCourses(appDAO);
		};
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 1;

		Student student = appDAO.findStudentAndCourseByStudentId(theId);

		System.out.println("Student: " + student);

		System.out.println("Courses: " + student.getCourses());

		System.out.println("Done");
	}

	private void findCourseAndStudent(AppDAO appDAO) {
		int theId = 10;

		Course course = appDAO.findCourseAndStudentByCourseId(theId);

		System.out.println("Course: " + course);
		System.out.println("Students: " + course.getStudents());

		System.out.println("Done");
	}

	private void createCourseAndStudent(AppDAO appDAO) {

		// create a course
		Course course = new Course("Pacman");

		// add some course
		// add student to the course
		course.addStudent(new Student("John", "Doe", "Matee@mil.com"));
		course.addStudent(new Student("mateen", "abdul", "mail@test.com"));

		// save the coursse and associated students
		System.out.println("Saving the course" + course);
		System.out.println("Associated Students" + course.getStudents());

		appDAO.save(course);

		System.out.println("Done");
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Finding course with id: " + theId);
		appDAO.deleteCourseById(theId);

		System.out.println("Done");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theid = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theid);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done");

	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course course = new Course("Pacman");

		// add some course
		course.addReview(new Review("Great course"));
		course.addReview(new Review("Best"));
		course.addReview(new Review("What a dumb course"));

		// save the course ... and leverate the cascade all
		System.out.println("Saving the course");
		System.out.println(course);
		System.err.println(course.getReviews());

		appDAO.save(course);

		System.out.println("Done");

	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;

		// find the course
		System.out.println("Finding course with id: " + theId);
		Course course = appDAO.findCourseById(theId);

		System.out.println("Deleting course: " + course);

		appDAO.deleteCourseById(theId);

		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		// find the course
		System.out.println("Finding course with id: " + theId);
		Course course = appDAO.findCourseById(theId);

		System.out.println("Updating course: " + course);
		course.setTitle("youtube");

		// update the course
		appDAO.update(course);

		System.out.println("Done");

	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instructor: " + theId);

		tempInstructor.setFirstName("Scooby");

		appDAO.update(tempInstructor);

		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		// get the instructor
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Instructor: " + tempInstructor);
		System.out.println(tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Instructor: " + tempInstructor);

		// find coureses for instructor
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("Courses: " + tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Instructor: " + tempInstructor);

		System.out.println("Courses: " + tempInstructor.getCourses());

		System.out.println("Done");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("user2", "2", "user2@mail.com");
		// create instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/y", "gaming");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// creaaate courses
		Course tempCourse1 = new Course("air guitar");
		Course tempCourse2 = new Course("Pinball");
		Course tempCourse3 = new Course("Coding");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		// save the instructor
		// this will also save the courses
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done");
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
		int theId = 1;
		System.out.println("Deleting instructor with id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done");
	}

	private void findInstructorById(AppDAO appDAO) {
		int theId = 2;

		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Instructor: " + tempInstructor);
		System.out.println("Instructor Details: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// // create the instructor
		// Instructor tempInstructor = new
		// Instructor("Abdul","Mateen","abdulmateen@duck.com");
		// InstructorDetail tempInstructorDetail = new
		// InstructorDetail("http://www.youtube.com/abdulmateenzwl","code!!!");

		// create the instructor
		Instructor tempInstructor = new Instructor("user2", "2", "user2@mail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/y", "test");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}
}
