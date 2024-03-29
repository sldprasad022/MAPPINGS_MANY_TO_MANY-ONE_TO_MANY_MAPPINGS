package com.techpixe.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.entity.Employee;
import com.techpixe.entity.TeamLead;
import com.techpixe.repository.EmployeeRepository;
import com.techpixe.repository.TeamLeadRepository;
import com.techpixe.service.EmployeeService;

@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TeamLeadRepository teamLeadRepository;

	@Override
	public Employee save(Long teamLead, String employeeName, double experience, double salary) {
		TeamLead teamLead1 = teamLeadRepository.findById(teamLead)
				.orElseThrow(() -> new NoSuchElementException("Team Lead " + teamLead + " is not Present"));
		if (teamLead1 != null) {
			System.out.println("**********Team Lead Id is Present***********");

			Employee employee = new Employee();
			employee.setEmployeeName(employeeName);
			employee.setExperience(experience);
			employee.setTeamLead(teamLead1);
			employee.setSalary(salary);
			employee.setRole("Employee");
			return employeeRepository.save(employee);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team Lead " + teamLead + " is not Present");
		}
	}

	public Employee fetchById(Long id) {
		return employeeRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Id " + id + " is not Present "));
	}

	public List<Employee> all() {
		List<Employee> fetchedAll = employeeRepository.findAll();
		if (fetchedAll.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No records are Present");
		}
		return fetchedAll;
	}

	@Override
	public List<Employee> findByEmployeeNameContains(String employeeName) {
		List<Employee> all = employeeRepository.findByEmployeeNameContaining(employeeName);
		if (all.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not contain any Name");
		}
		return all;
	}

	@Override
	public List<Employee> findBySalaryLessThan(double salary) {
		List<Employee> all=  employeeRepository.findBySalaryLessThan(salary);
		if (all.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No One is Present with Less than "+salary+" salary");
		}
		return all;
	}

}
