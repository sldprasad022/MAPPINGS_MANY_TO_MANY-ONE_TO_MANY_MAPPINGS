package com.techpixe.service;

import java.util.List;

import com.techpixe.entity.Employee;

public interface EmployeeService {
	Employee save(Long teamLead, String employeeName, double experience, double salary);

	Employee fetchById(Long id);

	List<Employee> all();

	List<Employee> findByEmployeeNameContains(String employeeName);

	List<Employee> findBySalaryLessThan(double salary);
	
	void deleteById(Long id);

}
