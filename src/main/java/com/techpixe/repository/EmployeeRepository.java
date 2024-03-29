package com.techpixe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpixe.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
