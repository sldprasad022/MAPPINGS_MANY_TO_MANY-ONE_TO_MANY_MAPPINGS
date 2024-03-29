package com.techpixe.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamLead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamLeadId;

	private String teamLeadName;

	private String role;

	private double experience;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private Manager manager;

	@OneToMany(mappedBy = "teamLead", fetch = FetchType.EAGER)
	private List<Employee> allEmployees = new ArrayList<>();
}
