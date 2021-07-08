package com.example.springdataexampleh2.details;

import com.example.springdataexampleh2.model.Employee;
import com.example.springdataexampleh2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EmployeeDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository repository;

    public UserDetails loadUserByUsername(String name)
            throws UsernameNotFoundException {
        Employee employee = repository.findEmployeeByName(name);

        if (employee == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new EmployeeDetails(employee);
    }
}
