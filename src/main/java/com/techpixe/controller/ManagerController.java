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

import com.techpixe.entity.Manager;
import com.techpixe.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;

	@PostMapping("/save")
	public ResponseEntity<Manager> save(@RequestParam String managerName, @RequestParam double experience) {
		Manager savedManager = managerService.save(managerName, experience);
		return new ResponseEntity<Manager>(savedManager, HttpStatus.CREATED);
	}

	@GetMapping("/fetchById/{id}")
	public ResponseEntity<?> fetchById(@PathVariable Long id) {
		Manager fetchById = managerService.fetchById(id);
		return ResponseEntity.ok(fetchById);
	}

	@GetMapping("/all")
	public ResponseEntity<List<?>> allManagers() {
		List<Manager> all = managerService.all();
		return ResponseEntity.ok(all);
	}
}
