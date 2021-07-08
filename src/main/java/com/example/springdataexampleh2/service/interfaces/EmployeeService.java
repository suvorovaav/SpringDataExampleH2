package com.example.springdataexampleh2.service.interfaces;

import com.example.springdataexampleh2.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeById(Integer id);

    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    void deleteEmployeeByName(String name);

    void deleteEmployeeById(Integer id);

}
