package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint.entities.SecurityAlert;

public interface ISecurityAlertRepository extends JpaRepository<SecurityAlert, Long>{

//	@Query("Select a FROM ")//Use JOins
//	public List<SecurityAlert> getSecurityAlertsByAdminId();
	
	
	
}
