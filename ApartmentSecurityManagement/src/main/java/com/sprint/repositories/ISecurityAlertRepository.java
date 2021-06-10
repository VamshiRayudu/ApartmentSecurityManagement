package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint.entities.SecurityAlert;

public interface ISecurityAlertRepository extends JpaRepository<SecurityAlert, Long>{

	@Query("select a FROM SecurityAlert a WHERE a.admin.id =?1")
	public List<SecurityAlert> getAdminSecurityAlertsById(Long id);
	
	@Query("select a FROM SecurityAlert a WHERE a.guard.id =?1")
	public List<SecurityAlert> getGuardSecurityAlertsById(Long id);

}
