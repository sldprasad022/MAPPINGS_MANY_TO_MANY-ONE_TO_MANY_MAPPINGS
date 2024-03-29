package com.techpixe.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.entity.Manager;
import com.techpixe.entity.TeamLead;
import com.techpixe.repository.ManagerRepository;
import com.techpixe.repository.TeamLeadRepository;
import com.techpixe.service.TeamLeadService;

@Service
public class TeamLeadServiceImpl implements TeamLeadService {
	@Autowired
	private TeamLeadRepository teamLeadRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public TeamLead save(Long manager, String teamLeadName, double experience) {
		Manager manager1 = managerRepository.findById(manager)
				.orElseThrow(() -> new NoSuchElementException("Manager " + manager + " Id is not Present "));

		if (manager1 != null) {
			TeamLead teamLead = new TeamLead();
			teamLead.setExperience(experience);
			teamLead.setTeamLeadName(teamLeadName);
			teamLead.setRole("Team Lead");
			teamLead.setManager(manager1);
			return teamLeadRepository.save(teamLead);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager " + manager + " Id is not Present  ");
		}
	}

	@Override
	public TeamLead fetchById(Long id) {
		// return teamLeadRepository.findById(id).orElseThrow(()-> new
		// NoSuchElementException("Team Lead "+id+" is not present "));
		TeamLead fetchById = teamLeadRepository.findById(id).get();
		if (fetchById == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team Lead " + id + " is not present");
		}
		return fetchById;
	}

	@Override
	public List<TeamLead> all() {
		List<TeamLead> all = teamLeadRepository.findAll();
		if (all.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No records are Present");
		}
		return all;
	}

}
