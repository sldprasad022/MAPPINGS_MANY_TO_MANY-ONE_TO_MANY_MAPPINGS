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

import com.techpixe.entity.TeamLead;
import com.techpixe.service.TeamLeadService;

@RestController
@RequestMapping("/teamlead")
public class TeamLeadController {
	@Autowired
	private TeamLeadService teamLeadService;

	@PostMapping("/save/{manager}")
	public ResponseEntity<TeamLead> save(@PathVariable Long manager, @RequestParam String teamLeadName,
			@RequestParam double experience) {
		TeamLead saved = teamLeadService.save(manager, teamLeadName, experience);
		return new ResponseEntity<TeamLead>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/fetchById/{teamLeadId}")
	public ResponseEntity<?> fetchById(@PathVariable("teamLeadId") Long id) {
		TeamLead fetchById = teamLeadService.fetchById(id);
		return ResponseEntity.ok(fetchById);
	}

	@GetMapping("/all")
	public ResponseEntity<List<?>> allTeamLeads() {
		List<TeamLead> fetchAll = teamLeadService.all();
		return ResponseEntity.ok(fetchAll);
	}

}
