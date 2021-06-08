package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Owner;
import com.sprint.entities.SecurityAlert;
import com.sprint.repositories.ISecurityAlertRepository;

@Service
@Transactional
public class SecurityAlertServiceImpl implements ISecurityAlertService{

	@Autowired
	private ISecurityAlertRepository securityAlertRepository;

	@Override
	public SecurityAlert addSecurityAlert(SecurityAlert securityAlert) {
		// TODO Auto-generated method stub
		return securityAlertRepository.saveAndFlush(securityAlert);
	}

	@Override
	public SecurityAlert updateSecurityAlert(SecurityAlert securityAlert) {
		// TODO Auto-generated method stub
		return securityAlertRepository.saveAndFlush(securityAlert);
	}

	@Override
	public SecurityAlert updateSecurityAlertById(Long Id,String oldMessage,String newMessage) {
		// TODO Auto-generated method stub
		SecurityAlert securityAlert = securityAlertRepository.findById(Id).get();
		if( securityAlert.getMessage()==oldMessage)
		{
			securityAlert.setMessage(newMessage);
			securityAlertRepository.saveAndFlush(securityAlert);
		}
		return securityAlert;

	}

	@Override
	public SecurityAlert getSecurityAlertById(Long Id) {
		// TODO Auto-generated method stub
		return securityAlertRepository.getById(Id);
	}

	@Override
	public List<SecurityAlert> getSecurityAlertList() {
		// TODO Auto-generated method stub
		return securityAlertRepository.findAll();
	}


	@Override
	public SecurityAlert deleteSecurityAlertById(Long id) {
		// TODO Auto-generated method stub
		SecurityAlert securityAlert = securityAlertRepository.findById(id).get();

		securityAlertRepository.deleteById(id);

		return securityAlert;
	}

}
