package com.techpixe.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
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

	@OneToMany(mappedBy = "teamLead", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> allEmployees = new ArrayList<>();
	
	
	/*cascade = cascadeType.ALL ::
              It will  perform the operations in both table. 
      Example delete Operation ::
              whatever data is created based on Id the entire objects will be deleted
              in both tables(Parent table , Child table).

      In the Parent class, the children field is annotated with @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL).
      This means that when you perform operations such as save, update, or delete on a Parent entity, 
      the corresponding cascade operations will be applied to its associated Child entities.
   */
}
