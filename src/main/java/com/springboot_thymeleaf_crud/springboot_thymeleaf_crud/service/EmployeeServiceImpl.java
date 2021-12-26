package com.springboot_thymeleaf_crud.springboot_thymeleaf_crud.service;

import java.util.List;
import java.util.Optional;

import com.springboot_thymeleaf_crud.springboot_thymeleaf_crud.model.Employee;
import com.springboot_thymeleaf_crud.springboot_thymeleaf_crud.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        if (!employee.getFirstName().equals("")
                && !employee.getLastName().equals("")
                && !employee.getEmail().equals("")) {
            this.employeeRepository.save(employee);
        } 
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id = " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);        
    }
}