package com.techpixe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpixe.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByEmployeeNameContaining(String employeeName);

	List<Employee> findBySalaryLessThan(double salary);
	
	//List<Employee> findByExperienceIsLessThanEqual(double experience);
}
