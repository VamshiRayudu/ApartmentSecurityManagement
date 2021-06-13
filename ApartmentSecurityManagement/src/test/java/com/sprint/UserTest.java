package com.sprint;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.entities.Admin;
import com.sprint.entities.Guard;
import com.sprint.entities.Owner;
import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IGuardRepository;
import com.sprint.repositories.IOwnerRepository;
import com.sprint.repositories.IUserRepository;
import com.sprint.services.AdminServiceImpl;
import com.sprint.services.GuardServiceImpl;
import com.sprint.services.OwnerServiceImpl;
import com.sprint.services.UserServiceImpl;

@SpringBootTest
class UserTest {

	@Mock

	IUserRepository userRepository= org.mockito.Mockito.mock(IUserRepository.class);

	@InjectMocks
	UserServiceImpl userService;
	
	@Mock
	IAdminRepository adminRepository= org.mockito.Mockito.mock(IAdminRepository.class);
	@InjectMocks
	AdminServiceImpl adminService;

	@Mock
	IGuardRepository guardRepository= org.mockito.Mockito.mock(IGuardRepository.class);
	@InjectMocks
	GuardServiceImpl guardService;
	
	@Mock
	IOwnerRepository ownerRepository= org.mockito.Mockito.mock(IOwnerRepository.class);
	@InjectMocks
	OwnerServiceImpl ownerService;
	
	@Test
	public void addUser() {
		
		User user = new User();
		user.setName("Demo");
		user.setMobileNumber(1232L);
		user.setPassword("Demo@12");
		user.setRole(Role.ADMIN);
		user.setEmailId("sample@test");
		User u = userService.registerUser(user);
		assertEquals(u, user);

	} 
	
	@Test
	public void loginUserAdmin() {
		Admin admin = new Admin(1L,"vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
		Mockito.when(adminRepository.findById(admin.getId())).thenReturn(Optional.of(admin));
		assertEquals("sampleTest@asp.com",admin.getEmailId());
		assertEquals("password",admin.getPassword());
	}
	
	
	@Test
	public void loginAdminWithWrongPassword() {
		Admin admin = new Admin(1L,"vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
		Mockito.when(adminRepository.findById(admin.getId())).thenReturn(Optional.of(admin));
		assertNotEquals("sampleTest@asp.com",admin.getEmailId());
		assertNotEquals("password",admin.getPassword());
	}
	
	
	@Test
	public void loginGuardUser() {

		Guard guard = new Guard(3L,"vamshi","rayudu",12223L,"sampleguard@asp.com","password",Role.GUARD);
		Mockito.when(guardRepository.findById(guard.getId())).thenReturn(Optional.of(guard));
		assertEquals("sampleguard@asp.com",guard.getEmailId());
		assertEquals("password",guard.getPassword());
	}
	
	
	@Test
	public void loginGuardWithWrongPassword() {
		Guard guard = new Guard(3L,"vamshi","rayudu",12223L,"sampleguard@asp.com","password",Role.GUARD);
		Mockito.when(guardRepository.findById(guard.getId())).thenReturn(Optional.of(guard));;
		assertNotEquals("sampleguard@asp.com",guard.getEmailId());
		assertNotEquals("password",guard.getPassword());
	}
	
	
	@Test
	public void loginOwnerUser() {

		Owner owner = new Owner(3L,"vamshi","rayudu",12223L,"sampleguard@asp.com","password",Role.FLATOWNER);
		Mockito.when(ownerRepository.findById(owner.getId())).thenReturn(Optional.of(owner));
		assertEquals("sampleguard@asp.com",owner.getEmailId());
		assertEquals("password",owner.getPassword());
	}
	
	
	@Test
	public void loginOwnerWithWrongPassword() {
		Owner owner = new Owner(3L,"vamshi","rayudu",12223L,"sampleguard@asp.com","password",Role.FLATOWNER);
		Mockito.when(ownerRepository.findById(owner.getId())).thenReturn(Optional.of(owner));
		assertNotEquals("sampleguard@asp.com",owner.getEmailId());
		assertNotEquals("password",owner.getPassword());
	}
}
