package com.sprint;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.repositories.IUserRepository;
import com.sprint.services.UserServiceImpl;

class UserTest {

	@Mock

	IUserRepository userRepository= org.mockito.Mockito.mock(IUserRepository.class);

	@InjectMocks
	UserServiceImpl userService = new UserServiceImpl();

	@Test
	public void addUser() {
		
		User user = new User();
		user.setName("Demo");
		user.setId(12L);
		user.setMobileNumber(1232L);
		user.setPassword("Demo@12");
		user.setRole(Role.ADMIN);
		user.setEmailId("sample@test");
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		userService.addUser(user);
		verify(userRepository, times(1)).save(user);

	} 

	@Test
	public void testGetUserById() {

		User user = new User();
		user.setName("Demo");
		user.setId(12L);
		user.setMobileNumber(1232L);
		user.setPassword("Demo@12");
		user.setRole(Role.ADMIN);
		user.setEmailId("sample@test");
		
		Mockito.when(userRepository.getById(user.getId())).thenReturn(user);

		User u = userService.getUserById(user.getId());
		
	    assertEquals(u,user);
	    
	    verify(userRepository, times(1)).getById(u.getId());
	}
	
	
	@Test
	public void deleteAdmin() {
		User user = new User();
		user.setName("Demo");
		user.setId(12L);
		user.setMobileNumber(1232L);
		user.setPassword("Demo@12");
		user.setRole(Role.ADMIN);
		user.setEmailId("sample@test");
		
        Mockito.when(userRepository.getById(user.getId())).thenReturn(user);
        assertEquals(user, userService.deleteUserById(user.getId()));
	}
}
