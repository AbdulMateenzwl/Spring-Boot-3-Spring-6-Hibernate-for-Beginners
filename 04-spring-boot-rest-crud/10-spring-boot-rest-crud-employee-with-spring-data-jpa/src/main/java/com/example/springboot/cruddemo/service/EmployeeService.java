package com.example.springboot.cruddemo.service;

import java.util.List;

import com.example.springboot.cruddemo.entitiy.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    
    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
