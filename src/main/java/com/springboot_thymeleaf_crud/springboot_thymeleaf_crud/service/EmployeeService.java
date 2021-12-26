package com.springboot_thymeleaf_crud.springboot_thymeleaf_crud.service;

import java.util.List;

import com.springboot_thymeleaf_crud.springboot_thymeleaf_crud.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);
}