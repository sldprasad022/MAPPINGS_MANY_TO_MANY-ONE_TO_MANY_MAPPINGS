package com.techpixe.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.entity.Manager;
import com.techpixe.repository.ManagerRepository;
import com.techpixe.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public Manager save(String managerName, double experience) {
		Manager manager = new Manager();
		manager.setExperience(experience);
		manager.setRole("Manager");
		manager.setManagerName(managerName);
		return managerRepository.save(manager);
	}

	@Override
	public Manager fetchById(Long id) {
		return managerRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Manager "+id+"  is not Present"));
	}

	@Override
	public List<Manager> all() {
		List<Manager> allManagers = managerRepository.findAll();
		if (allManagers.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No records Present");
		}
		return allManagers;
	}

	@Override
	public void deleteById(Long id) {
		managerRepository.deleteById(id);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
