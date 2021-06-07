package com.sprint.services;

import java.util.List;
import com.sprint.entities.SecurityAlert;

public interface ISecurityAlertService {
	
	public List<SecurityAlert> getSecurityAlertList();
	
	public SecurityAlert addSecurityAlert(SecurityAlert securityAlert);
	
	public SecurityAlert updateSecurityAlert(SecurityAlert securityAlert);
	
    public SecurityAlert updateSecurityAlertById(Long Id);
    
	public SecurityAlert getSecurityAlertById(Long Id);

}