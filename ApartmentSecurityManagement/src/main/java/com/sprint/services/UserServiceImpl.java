package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Admin;
import com.sprint.entities.Guard;
import com.sprint.entities.Owner;
import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IGuardRepository;
import com.sprint.repositories.IOwnerRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IAdminRepository adminRepository;
	
	@Autowired
	private IGuardRepository guardRepository;
	
	@Autowired
	private IOwnerRepository ownerRepository;

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		if(user.getRole() == Role.ADMIN)
		{
			Admin adm = new Admin();
			adm.setEmailId(user.getEmailId());
			adm.setMobileNumber(user.getMobileNumber());
			adm.setName(user.getUserName());
			adm.setPassword(user.getPassword());
			adm.setRole(user.getRole());
			adm.setPassword(user.getName());
			adm = adminRepository.save(adm);
		}
		else if(user.getRole() == Role.GUARD)
		{
			Guard gd = new Guard();
			gd.setEmailId(user.getEmailId());
			gd.setMobileNumber(user.getMobileNumber());
			gd.setName(user.getUserName());
			gd.setPassword(user.getPassword());
			gd.setRole(user.getRole());
			gd.setPassword(user.getName());
			gd = guardRepository.save(gd);
		}
		else if(user.getRole() == Role.FLATOWNER)
		{
			Owner owner = new Owner();
			owner.setEmailId(user.getEmailId());
			owner.setMobileNumber(user.getMobileNumber());
			owner.setName(user.getUserName());
			owner.setPassword(user.getPassword());
			owner.setRole(user.getRole());
			owner.setPassword(user.getName());
			owner = ownerRepository.save(owner);
		}
		return user;
	}


	@Override
	public User Login(String emailId, String password, Role role) {
		// TODO Auto-generated method stub

		if(role == Role.ADMIN)
		{
			Admin admin = (Admin) adminRepository.findByEmailId(emailId);
			return admin;
		}
		else if(role == Role.GUARD)
		{
			Guard guard = guardRepository.findByEmailId(emailId);
			return guard;
		}
		else if(role == Role.FLATOWNER)
		{
			Owner owner = ownerRepository.findByEmailId(emailId);
			return owner;
		}
		return null;
	}

	@Override
	public User Logout(String emailId, String password, Role role) {
		// TODO Auto-generated method stub
		if(role == Role.ADMIN)
		{
			Admin admin = (Admin) adminRepository.findByEmailId(emailId);
			return admin;
		}
		else if(role == Role.GUARD)
		{
			Guard guard = guardRepository.findByEmailId(emailId);
			return guard;
		}
		else if(role == Role.FLATOWNER)
		{
			Owner owner = ownerRepository.findByEmailId(emailId);
			return owner;
		}
		return null;
	}
}
