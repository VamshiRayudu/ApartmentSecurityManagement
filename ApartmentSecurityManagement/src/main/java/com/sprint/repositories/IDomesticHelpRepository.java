package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.DomesticHelp;

public interface IDomesticHelpRepository extends JpaRepository<DomesticHelp, Long>{

	//Use Join Query
	//public List<DomesticHelp> getDomesticHelpByFlatNumber(Long FlatNumber);
}
