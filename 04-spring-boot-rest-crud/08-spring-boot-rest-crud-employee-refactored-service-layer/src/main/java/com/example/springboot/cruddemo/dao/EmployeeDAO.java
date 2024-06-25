package com.example.springboot.cruddemo.dao;

import java.util.List;

import com.example.springboot.cruddemo.entitiy.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();

}
