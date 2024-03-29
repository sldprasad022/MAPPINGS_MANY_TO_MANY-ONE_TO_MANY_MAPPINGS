package com.techpixe.service;

import java.util.List;

import com.techpixe.entity.Manager;

public interface ManagerService {
	Manager save(String managerName, double experience);

	Manager fetchById(Long id);

	List<Manager> all();
}
