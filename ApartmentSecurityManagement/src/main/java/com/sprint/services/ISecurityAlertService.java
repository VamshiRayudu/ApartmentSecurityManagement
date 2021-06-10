package com.sprint.services;

import java.util.List;
import com.sprint.entities.SecurityAlert;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;

public interface ISecurityAlertService {
	
	public SecurityAlert addSecurityAlert(SecurityAlert securityAlert);
	
	public SecurityAlert updateSecurityAlert(SecurityAlert securityAlert) throws RecordNotFoundException;
	
    public SecurityAlert updateSecurityAlertById(Long Id,String oldMessage,String newMessage) throws RecordNotFoundException;
    
	public SecurityAlert getSecurityAlertById(Long Id) throws RecordNotFoundException;
	
	public List<SecurityAlert> getSecurityAlertList();
	
	 public SecurityAlert deleteSecurityAlertById(Long  id) throws RecordNotFoundException;
}

