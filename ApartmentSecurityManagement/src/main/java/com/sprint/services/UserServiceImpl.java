package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Admin;
import com.sprint.entities.Guard;
import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IGuardRepository;
import com.sprint.repositories.IUserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IAdminRepository adminRepository;
	
	@Autowired
	private IGuardRepository guardRepository;

	@Override
	public boolean LoginUser(String emailId, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmailId(emailId);
		if(user.getPassword() == password)
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		User userDb = userRepository.saveAndFlush(user);
		if(userDb.getRole() == Role.ADMIN)
		{
			Admin admin = adminRepository.saveAndFlush((Admin)userDb);
		}
		else if(userDb.getRole() == Role.GUARD)
		{
			Guard guard = guardRepository.saveAndFlush((Guard)userDb);
		}
		else if(userDb.getRole() == Role.FLATOWNER)
		{
			Admin a = adminRepository.saveAndFlush((Admin)user);
		}
		return userDb;
	}

	@Override
	public User deleteUserById(Long id) {
		// TODO Auto-generated method stub
		User user = adminRepository.findById(id).get();
		
		//performing a delete operation  on this id 
		userRepository.deleteById(id);
		
		return user;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
}
