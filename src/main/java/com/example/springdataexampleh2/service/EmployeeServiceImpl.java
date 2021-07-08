package com.example.springdataexampleh2.service;

import com.example.springdataexampleh2.model.Employee;
import com.example.springdataexampleh2.repository.EmployeeRepository;
import com.example.springdataexampleh2.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Service - класс является сервисом для реализации бизнес логики
 * */

@Component
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return repository.findEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return repository.findEmployeeByName(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(employee.getPassword()));
        repository.save(employee);
    }

    @Override
    public void deleteEmployeeByName(String name){
        repository.deleteEmployeeByName(name);
    }

    @Override
    public void deleteEmployeeById(Integer id){
        repository.deleteEmployeeById(id);
    }
}
