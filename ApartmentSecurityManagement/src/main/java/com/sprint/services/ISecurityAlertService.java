package com.sprint.services;

import java.util.List;
import com.sprint.entities.SecurityAlert;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;

/**
 * @author VIVEK PABBA
 *
 */
public interface ISecurityAlertService {
	
	/**
	 * @param securityAlert
	 * @return
	 */
	public SecurityAlert addSecurityAlert(SecurityAlert securityAlert);
	
	/**
	 * @param securityAlert
	 * @return
	 * @throws RecordNotFoundException
	 */
	public SecurityAlert updateSecurityAlert(SecurityAlert securityAlert) throws RecordNotFoundException;
	
    /**
     * @param Id
     * @param oldMessage
     * @param newMessage
     * @return
     * @throws RecordNotFoundException
     */
    public SecurityAlert updateSecurityAlertById(Long Id,String oldMessage,String newMessage) throws RecordNotFoundException;
    
	/**
	 * @param Id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public SecurityAlert getSecurityAlertById(Long Id) throws RecordNotFoundException;
	
	/**
	 * @return
	 */
	public List<SecurityAlert> getSecurityAlertList();
	
	 /**
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public SecurityAlert deleteSecurityAlertById(Long  id) throws RecordNotFoundException;
}

