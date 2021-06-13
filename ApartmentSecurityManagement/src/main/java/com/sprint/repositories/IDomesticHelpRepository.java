package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entities.DomesticHelp;

@Repository
public interface IDomesticHelpRepository extends JpaRepository<DomesticHelp, Long> {

	// Use Join Query
	// public List<DomesticHelp> getDomesticHelpByFlatNumber(Long FlatNumber);
}
