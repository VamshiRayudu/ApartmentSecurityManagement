package com.sprint;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint.entities.Admin;
import com.sprint.entities.Role;
import com.sprint.repositories.IAdminRepository;
import com.sprint.services.AdminServiceImpl;

class AdminTest {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl; 
	
	@Mock

	IAdminRepository adminRepository= org.mockito.Mockito.mock(IAdminRepository.class);

	@InjectMocks

	AdminServiceImpl adminService = new AdminServiceImpl();

	@Test

	public void addAdminTest() {
		
    Admin a = new Admin();
    
    Admin a2 = new Admin();
    
    a.setMobileNumber(123L);
    a.setEmailId("sampleTest@asp.com");
    a.setRole(Role.ADMIN);
    a.setName("test");
    
    a2.setMobileNumber(123L);
    a2.setEmailId("sampleTest@asp.com");
    a2.setRole(Role.ADMIN);
    a2.setName("test");
    
    Mockito.when(adminRepository.save(a2)).thenReturn(a2);
    
  //  adminService.addAdmin(a2);
    
    assertEquals(a,adminService.addAdmin(a));
    
    //verify(adminRepository.save(a),times(1));
	}
}