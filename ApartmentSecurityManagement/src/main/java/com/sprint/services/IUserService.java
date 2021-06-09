package com.sprint.services;

import java.util.List;

import com.sprint.entities.Role;
import com.sprint.entities.User;

public interface IUserService {
	
	public User registerUser(User user);
	
	public User Login(String emailId,String password, Role role);
	
	public User Logout(String emailId,String password,Role role);
}
