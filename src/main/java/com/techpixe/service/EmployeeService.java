package com.techpixe.service;

import java.util.List;

import com.techpixe.entity.Employee;

public interface EmployeeService {
	Employee save(Long teamLead, String employeeName, double experience, double salary);

	Employee fetchById(Long id);

	List<Employee> all();

}
