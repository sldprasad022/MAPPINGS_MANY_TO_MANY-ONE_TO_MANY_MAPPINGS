package com.techpixe.service;

import java.util.List;

import com.techpixe.entity.TeamLead;

public interface TeamLeadService {
	TeamLead save(Long manager, String teamLeadName, double experience);

	TeamLead fetchById(Long id);

	List<TeamLead> all();
}
