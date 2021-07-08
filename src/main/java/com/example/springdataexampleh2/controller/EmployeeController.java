package com.example.springdataexampleh2.controller;

import com.example.springdataexampleh2.model.Employee;
import com.example.springdataexampleh2.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Autowired – аннотация позволяет автоматически установить значение поля.
 * Функциональность этой аннотации заключается в том, что нам не нужно заботиться о том,
 * как лучше всего Bean'у передать экземпляр другого Bean'a.
 * Spring сам найдет нужный Bean и подставит его значение в свойство,
 * которое отмечено аннотацией.
 * */

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello-employee")
    public String helloWorld() {
        return "For employee";
    }

    @GetMapping("/hello-manager")
    public String helloWorld1() {
        return "For manager";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }


}
