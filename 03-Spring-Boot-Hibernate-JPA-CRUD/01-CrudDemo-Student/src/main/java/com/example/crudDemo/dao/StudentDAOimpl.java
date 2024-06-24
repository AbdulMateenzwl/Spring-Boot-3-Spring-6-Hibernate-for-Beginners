package com.example.crudDemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.crudDemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOimpl implements StudentDAO{

    // define fields for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement methods
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findbyId(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

        // set query parameters
        theQuery.setParameter("theData",lastName);

        // return results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        
        // find Student
        Student theStudent = entityManager.find(Student.class,id);

        // delete Student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int noRowDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return noRowDeleted;
    }
}
