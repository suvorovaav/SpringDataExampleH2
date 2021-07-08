package com.example.springdataexampleh2.repository;

import com.example.springdataexampleh2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
