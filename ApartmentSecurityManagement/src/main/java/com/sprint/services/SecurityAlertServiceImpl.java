package com.sprint.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Owner;
import com.sprint.entities.SecurityAlert;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.ISecurityAlertRepository;

@Service
@Transactional
public class SecurityAlertServiceImpl implements ISecurityAlertService{

	@Autowired
	private ISecurityAlertRepository securityAlertRepository;

	@Override
	public SecurityAlert addSecurityAlert(SecurityAlert securityAlert) {
		// TODO Auto-generated method stub
		return securityAlertRepository.save(securityAlert);
	}

	@Override
	public SecurityAlert updateSecurityAlert(SecurityAlert securityAlert) throws RecordNotFoundException{
		// TODO Auto-generated method stub
		Optional<SecurityAlert> sAlert = securityAlertRepository.findById(securityAlert.getId());
		if(sAlert!=null)
		{
			return securityAlertRepository.save(securityAlert);
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found");
		}
	}


	@Override
	public SecurityAlert updateSecurityAlertById(Long id,String oldMessage,String newMessage) throws RecordNotFoundException {
		// TODO Auto-generated method stub	
		Optional<SecurityAlert> securityAlert =securityAlertRepository.findById(id);
		if(securityAlert!=null)
		{
			if(securityAlert.get().getMessage()== oldMessage) {
				securityAlert.get().setMessage(newMessage);
				return securityAlertRepository.save(securityAlert.get());
			}
			else
				throw new ValidationException("Invalid MobileNumber");
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found");
		}
	}	


	@Override
	public SecurityAlert getSecurityAlertById(Long id) throws RecordNotFoundException{
		// TODO Auto-generated method stub
		Optional<SecurityAlert> securityAlert= securityAlertRepository.findById(id);
		if(securityAlert!=null)
		{
			return securityAlertRepository.getById(id);
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found");
		}
	}

	@Override
	public List<SecurityAlert> getSecurityAlertList() {
		// TODO Auto-generated method stub
		return securityAlertRepository.findAll();
	}


	@Override
	public SecurityAlert deleteSecurityAlertById(Long id) throws RecordNotFoundException{
		// TODO Auto-generated method stub
		Optional<SecurityAlert> securityAlert=securityAlertRepository.findById(id);
		if(securityAlert!=null)
		{
			securityAlertRepository.delete(securityAlert.get());
			return securityAlert.get();
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found");
		}
	}

}
