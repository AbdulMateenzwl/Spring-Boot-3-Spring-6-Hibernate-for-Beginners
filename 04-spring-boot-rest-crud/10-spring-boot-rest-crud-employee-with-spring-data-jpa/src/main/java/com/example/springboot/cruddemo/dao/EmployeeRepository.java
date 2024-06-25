package com.example.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.cruddemo.entitiy.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
    // thats it ... no need to write any code LOL!
}
