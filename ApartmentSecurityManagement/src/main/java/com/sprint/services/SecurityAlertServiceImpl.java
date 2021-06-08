package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.entities.SecurityAlert;

@Service
@Transactional
public class SecurityAlertServiceImpl implements ISecurityAlertService{

	@Override
	public SecurityAlert addSecurityAlert(SecurityAlert securityAlert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecurityAlert updateSecurityAlert(SecurityAlert securityAlert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecurityAlert updateSecurityAlertById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecurityAlert getSecurityAlertById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecurityAlert> getSecurityAlertList() {
		// TODO Auto-generated method stub
		return null;
	}

}
