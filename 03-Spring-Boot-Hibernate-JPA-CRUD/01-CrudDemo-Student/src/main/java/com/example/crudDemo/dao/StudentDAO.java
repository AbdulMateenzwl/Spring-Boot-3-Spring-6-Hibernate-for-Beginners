package com.example.crudDemo.dao;

import java.util.List;

import com.example.crudDemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findbyId(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(int id);

    int deleteAll();
}
