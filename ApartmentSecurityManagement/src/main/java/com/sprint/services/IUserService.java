package com.sprint.services;

import java.util.List;

import com.sprint.entities.User;

public interface IUserService {
	
	public boolean LoginUser(String emailId,String password);
	
	public User addUser(User user);
	
	public User deleteUserById(Long id);
	
	public User getUserById(Long id);
	
	public List<User> getUserList();
}
