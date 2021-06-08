package com.sprint;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sprint.entities.Admin;
import com.sprint.entities.Role;
import com.sprint.repositories.IAdminRepository;
import com.sprint.services.AdminServiceImpl;

class AdminTest {
	
	@Mock

	IAdminRepository adminRepository= org.mockito.Mockito.mock(IAdminRepository.class);

	@InjectMocks
	AdminServiceImpl adminService = new AdminServiceImpl();

	@Test
	public void testAddAdmin() {
		Admin admin = new Admin();
		admin.setMobileNumber(123L);
		admin.setEmailId("sampleTest@asp.com");
		admin.setRole(Role.ADMIN);
		admin.setName("test");
		admin.setUserName("demo");
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		adminService.addAdmin(admin);
		verify(adminRepository, times(1)).save(admin);
	}
	
	
	@Test
	public void testGetAdminById() {

		Admin admin = new Admin();
		admin.setMobileNumber(123L);
		admin.setEmailId("sampleTest@asp.com");
		admin.setRole(Role.ADMIN);
		admin.setName("test");
		admin.setUserName("demo");
		Mockito.when(adminRepository.getById(admin.getId())).thenReturn(admin);
		Admin a = adminService.getAdminById(admin.getId());
	    assertEquals(a,admin);
	    verify(adminRepository, times(1)).getById(admin.getId());
	}
	
	
	@Test
	public void deleteAdmin() {
		Admin admin = new Admin();
		admin.setMobileNumber(123L);
		admin.setEmailId("sampleTest@asp.com");
		admin.setRole(Role.ADMIN);
		admin.setName("test");
        Mockito.when(adminRepository.getById(admin.getId())).thenReturn(admin);
        assertEquals(admin, adminService.deleteAdminById(admin.getId()));
	}
    
	
	@Test
	public void testNotAddAdmin() {
		Admin admin1 = new Admin();
		admin1.setMobileNumber(123L);
		admin1.setEmailId("sampleTest@asp.com");
		admin1.setRole(Role.ADMIN);
		admin1.setName("test");

		Admin admin2 = new Admin();
		admin2.setMobileNumber(123L);
		admin2.setEmailId("sampleTest@asp.com");
		admin2.setRole(Role.ADMIN);
		admin2.setName("test");
		
		Mockito.when(adminRepository.save(admin1)).thenReturn(admin1);
		assertEquals(admin1, adminService.addAdmin(admin2));
	}
	
	@Test
	void testGetAllAdmins() {
		List<Admin>list = new ArrayList<>();
		Admin admin1 = new Admin();
		admin1.setMobileNumber(123L);
		admin1.setEmailId("sampleTest@asp.com");
		admin1.setRole(Role.ADMIN);
		admin1.setName("test");
		
		Admin admin2 = new Admin();
		admin2.setMobileNumber(123L);
		admin2.setEmailId("sampleTest@asp.com");
		admin2.setRole(Role.ADMIN);
		admin2.setName("test");
		list.add(admin1);
		list.add(admin2);
		Mockito.when(adminRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), adminService.getAllAdmins().size());
	}
}