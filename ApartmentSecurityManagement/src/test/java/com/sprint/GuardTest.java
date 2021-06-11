package com.sprint;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.entities.Guard;
import com.sprint.entities.Role;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IGuardRepository;
import com.sprint.services.GuardServiceImpl;

@SpringBootTest
class GuardTest {

	@Mock

	IGuardRepository guardRepository= org.mockito.Mockito.mock(IGuardRepository.class);

	@InjectMocks

	GuardServiceImpl guardService = new GuardServiceImpl();


	@Test
	public void testAddGuard() throws DuplicateRecordException 
	{
		Guard guard = new Guard("shubham","dwivedi",12223L,"sampleTest@asp.com","password",Role.ADMIN);
		Mockito.when(guardRepository.save(guard)).thenReturn(guard);
		guardService.addGuard(guard);
		assertEquals("shubham",guard.getUserName());
		assertEquals("password",guard.getPassword());
	}
	@Test
	public void deleteGuard() throws UserNotFoundException {

		Guard guard = new Guard(15L,"shubham","dwivedi",12223L,"sampleTest@asp.com","password",Role.GUARD);
		Mockito.when(guardRepository.findById(guard.getId())).thenReturn(Optional.of(guard));
		assertEquals(guard, guardService.deleteGuard(guard));
	}

	/*    @Test
	    public void testNotAddGuard() {
	        Guard guard1 = new Guard();
	        guard1.setMobileNumber(123L);
	        guard1.setEmailId("sampleTest@asp.com");
	        guard1.setRole(Role.GUARD);
	        guard1.setName("test");

	        Guard guard2 = new Guard();
	        guard2.setMobileNumber(123L);
	        guard2.setEmailId("sampleTest@asp.com");
	        guard2.setRole(Role.GUARD);
	        guard2.setName("test");

	        Mockito.when(guardRepository.save(guard1)).thenReturn(guard1);
	        assertEquals(guard1,guardService.addGuard(guard2));
	    }*/

	@Test
	void testGetAllGaurds() {
		List<Guard>list = new ArrayList<>();
		Guard guard1 = new Guard();
		guard1.setMobileNumber(123L);
		guard1.setEmailId("sampleTest@asp.com");
		guard1.setRole(Role.GUARD);
		guard1.setName("test");

		Guard guard2 = new Guard();
		guard2.setMobileNumber(123L);
		guard2.setEmailId("sampleTest@asp.com");
		guard2.setRole(Role.GUARD);
		guard2.setName("test");
		list.add(guard1);
		list.add(guard2);
		Mockito.when(guardRepository.findAll()).thenReturn(list);
		assertEquals(list.size(),guardService.getAllGuards().size());
	}
	
	@Test
    void testUpdateGuatdById()throws UserNotFoundException, DuplicateRecordException{
        Guard guard=new Guard();
        guard.setId(1L);
        guard.setUserName("shubham");
        guard.setName("dwivedi");
        guard.setMobileNumber(123456L);
        guard.setEmailId("sd9345@gmail.com");
        guard.setPassword("tata");
        guard.setRole(Role.GUARD);
        Mockito.when(guardRepository.save(guard)).thenReturn(guard);
        guardService.addGuard(guard);
        
        
        Mockito.when(guardRepository.findById(guard.getId())).thenReturn(Optional.of(guard));
        Guard g = guardService.updateGuardById(1L, "tata", "hehe");
        
        assertEquals("hehe", guard.getPassword());
   
    }
	
	
	
	
	
	
	
	
	
}