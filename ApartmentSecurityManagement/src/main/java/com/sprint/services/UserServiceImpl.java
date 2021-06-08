package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.entities.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Override
	public boolean LoginUser(String emailId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}
}
