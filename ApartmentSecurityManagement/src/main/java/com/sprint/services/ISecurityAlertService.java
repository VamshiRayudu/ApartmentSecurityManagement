package com.sprint.services;

import java.util.List;
import com.sprint.entities.SecurityAlert;

public interface ISecurityAlertService {
	
	public SecurityAlert addSecurityAlert(SecurityAlert securityAlert);
	
	public SecurityAlert updateSecurityAlert(SecurityAlert securityAlert);
	
    public SecurityAlert updateSecurityAlertById(Long Id,String oldMessage,String newMessage);
    
	public SecurityAlert getSecurityAlertById(Long Id);
	
	public List<SecurityAlert> getSecurityAlertList();
	
	 public SecurityAlert deleteSecurityAlertById(Long  id);
}

