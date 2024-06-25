package com.example.springboot.cruddemo.dao;

import java.util.List;

import com.example.springboot.cruddemo.entitiy.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
