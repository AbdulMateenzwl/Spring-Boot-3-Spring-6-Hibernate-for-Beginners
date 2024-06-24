package com.example.crudDemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.crudDemo.dao.StudentDAO;
import com.example.crudDemo.entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudent(studentDAO);

			// queryForStudentByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students ...");
		int count = studentDAO.deleteAll();
		System.out.println("Number of students deleted: "+count);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;

		System.out.println("Deleting student with id "+id);
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve based on the id
		int studentId = 2;
		Student student = studentDAO.findbyId(studentId);
		System.out.println("Getting Student with id "+ studentId);

		// change first name to "Mateen"
		student.setLastName("Mateen");
		System.out.println("updating student ...");

		// update the student
		studentDAO.update(student);
		System.out.println("Student updated successfully");

		// display the student
		System.out.println("Update Student "+student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		//display list of students
		for (Student tmpStudent: theStudents){
			System.out.println(tmpStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for (Student tmpStudent: theStudents){
			System.out.println(tmpStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create  a student object
		System.out.println("Creating new student object ...");
		Student studenttmp = new Student("Daffy", "Duck", "dafyy@mail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(studenttmp);

		// display id of student
		System.out.println("Saved student id: " + studenttmp.getId());

		// retrieve student based on the id
		Student student = studentDAO.findbyId(studenttmp.getId());

		// display student
		System.out.println("Retrieved student: " + student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student object ...");
		Student student1 = new Student("user1", "test", "user1@mail.com");
		Student student2 = new Student("user2", "test", "user2@mail.com");
		Student student3 = new Student("user3", "test", "user3@mail.com");
		
		// save student object
		System.out.println("Saving 3 student ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO){
		// create student object
		System.out.println("Creating new student object ...");
		Student student = new Student("John", "Doe", "test@mail.com");
		
		// save student object
		System.out.println("Saving the student ...");
		studentDAO.save(student);
		
		// Display Id of saved student
		System.out.println("Saved Student Id: " + student.getId());
		
	}

}
