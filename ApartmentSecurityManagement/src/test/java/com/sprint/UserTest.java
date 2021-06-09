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
import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IUserRepository;
import com.sprint.services.AdminServiceImpl;
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
	public void loginUser() {
		
		Admin admin = new Admin("vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		adminService.addAdmin(admin);
		Admin login = (Admin) adminService.Login(admin.getEmailId(), admin.getPassword(), admin.getRole());
		assertEquals("vamshi",login.getEmailId());
		assertEquals("password",login.getPassword());
	} 
		
}
