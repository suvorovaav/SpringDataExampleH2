package com.example.springdataexampleh2.repository;

import com.example.springdataexampleh2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository - класс используется для задания перечня
 * необходимых работ по поиску, получению и сохранению данных.
 * */

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeById(Integer id);
    Employee findEmployeeByName(String name);
    void deleteEmployeeByName(String name);
    void deleteEmployeeById(Integer id);

}
