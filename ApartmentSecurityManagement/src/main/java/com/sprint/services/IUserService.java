package com.sprint.services;

import java.util.List;

import com.sprint.entities.Role;
import com.sprint.entities.User;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
public interface IUserService {
	
	/**
	 * @param user
	 * @return
	 */
	public User registerUser(User user);
	
	/**
	 * @param emailId
	 * @param password
	 * @param role
	 * @return
	 */
	public User Login(String emailId,String password, Role role);
	
	/**
	 * @param emailId
	 * @param password
	 * @param role
	 * @return
	 */
	public User Logout(String emailId,String password,Role role);
}
