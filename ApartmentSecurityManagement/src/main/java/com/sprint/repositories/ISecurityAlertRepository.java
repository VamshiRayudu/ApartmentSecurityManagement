package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.SecurityAlert;

public interface ISecurityAlertRepository extends JpaRepository<SecurityAlert, Long>{

}
