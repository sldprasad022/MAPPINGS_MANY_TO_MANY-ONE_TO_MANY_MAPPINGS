package com.techpixe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techpixe.entity.Employee;
import com.techpixe.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save/{teamLead}")
	public ResponseEntity<Employee> saveEmployee(@PathVariable Long teamLead, @RequestParam String employeeName,
			@RequestParam double experience, @RequestParam double salary) {
		Employee saved = employeeService.save(teamLead, employeeName, experience, salary);
		return new ResponseEntity<Employee>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/fetchById/{employeeId}")
	public ResponseEntity<?> fetchById(@PathVariable("employeeId") Long id) {
		Employee fetchById = employeeService.fetchById(id);
		return ResponseEntity.ok(fetchById);
	}

	@GetMapping("/all")
	public ResponseEntity<List<?>> fetchAll() {
		List<Employee> fetchAll = employeeService.all();
		return ResponseEntity.ok(fetchAll);
	}
	
	
	@GetMapping("/containingLetter/{employeeName}")
	public ResponseEntity<List<?>> fetchAllNameContains(@PathVariable String employeeName)
	{
		List<Employee> fetchAllNameContains = employeeService.findByEmployeeNameContains(employeeName);
		return ResponseEntity.ok(fetchAllNameContains);
	}
}
