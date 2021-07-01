package com.sprint.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sprint.entities.User;
import com.sprint.repositories.IUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByEmailId(username).get(0);

		User validuser= userService.findUser(user);
	      if(validuser==null)
	    	  throw new UsernameNotFoundException("user not found"+username);
	      
	      return  new org.springframework.security.core.userdetails.User(validuser.getEmailId(), validuser.getPassword(), new ArrayList<>());
	      
	
	}
}