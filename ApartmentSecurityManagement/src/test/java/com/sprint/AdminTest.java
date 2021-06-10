package com.sprint;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.entities.Admin;
import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IAdminRepository;
import com.sprint.services.AdminServiceImpl;


@SpringBootTest
class AdminTest {
	
	@Mock
	IAdminRepository adminRepository= org.mockito.Mockito.mock(IAdminRepository.class);

	@InjectMocks
	AdminServiceImpl adminService;
	
	@Test
	public void testAddAdmin() throws DuplicateRecordException 
	{
		Admin admin = new Admin("vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		Admin a = adminService.addAdmin(admin);
		System.out.println(admin);
		System.out.println(a);
		assertEquals("vamshi",a.getUserName());
		assertEquals("password",a.getPassword());
	}
	

	@Test
	public void testGetAdminById() throws UserNotFoundException, DuplicateRecordException {

		Admin admin = new Admin("vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		adminService.addAdmin(admin);
		Mockito.when(adminRepository.findById(admin.getId())).thenReturn(Optional.of(admin));
		Admin a = adminService.getAdminById(admin.getId());
	    assertEquals(a,admin);
	}

	
	@Test
	public void deleteAdmin() throws UserNotFoundException {
		
		Admin admin = new Admin(15L,"vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
    	Mockito.when(adminRepository.findById(admin.getId())).thenReturn(Optional.of(admin));
        assertEquals(admin, adminService.deleteAdmin(admin));
	}

	@Test
    public void testDeleteById() throws UserNotFoundException {
    	Admin admin = new Admin(1L,"vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
    	Mockito.when(adminRepository.findById(admin.getId())).thenReturn(Optional.of(admin));
        assertEquals(admin, adminService.deleteAdminById(admin.getId()));
    }
    
    
	@Test
	void testUpdateAdmin() throws UserNotFoundException {
		Admin admin = new Admin("vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
		admin.setUserName("John");
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		adminService.updateAdmin(admin);
		assertEquals("John", admin.getUserName());
	}
	
	@Test
	void testUpdateAdminById() throws UserNotFoundException {
		Admin admin = new Admin(1L,"vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
    	Mockito.when(adminRepository.findById(admin.getId())).thenReturn(Optional.of(admin));
		Admin upPass = adminService.updateAdminById(admin.getId(), admin.getPassword(), "password2");
		assertEquals("password2", upPass.getPassword());
	}
	@Test
	void testGetAllAdmins() {
		
		List<Admin> list = new ArrayList();
		Admin admin = new Admin("vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
		
		Admin admin2 = new Admin("vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);

		list.add(admin);
		list.add(admin2);
		
		adminRepository.save(admin);
		adminRepository.save(admin2);
		
		Mockito.when(adminRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), adminService.getAllAdmins().size());
	}
	
	
//	@Test
//	public void testNotAddAdmin() {
//		Admin admin1 = new Admin("vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
//
//		Admin admin2 = new Admin("vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.ADMIN);
//		
//		Mockito.when(adminRepository.save(admin1)).thenReturn(admin1);
//		assertEquals(admin1, adminService.addAdmin(admin2));
//	}
}