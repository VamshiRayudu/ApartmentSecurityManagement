package com.sprint.services;

import java.util.List;

import org.springframework.context.annotation.Primary;

import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.exceptions.DuplicateRecordException;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
public interface IUserService {
	
	/**
	 * @param user
	 * @return
	 * @throws DuplicateRecordException 
	 */
	public User registerUser(User user) throws DuplicateRecordException;
	
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
	
	
	public User findUser(User user) ;
}
