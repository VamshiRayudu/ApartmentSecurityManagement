package com.sprint;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint.entities.Guard;
import com.sprint.entities.Role;
import com.sprint.repositories.IGuardRepository;
import com.sprint.services.GuardServiceImpl;

class GuardTest {
		
	@Mock

	IGuardRepository guardRepository= org.mockito.Mockito.mock(IGuardRepository.class);

	@InjectMocks

	GuardServiceImpl guardService = new GuardServiceImpl();

	 @Test
	    public void testAddGuard() {
	        Guard guard = new Guard();
	        guard.setMobileNumber(123L);
	        guard.setEmailId("sampleTest@asp.com");
	        guard.setRole(Role.GUARD);
	        guard.setName("test");
	        Mockito.when(guardRepository.save(guard)).thenReturn(guard);
	        assertEquals(guard,guardService.addGuard(guard));
	    }

	 
	 @Test
	    public void deleteGuard() {
		 Guard guard = new Guard();
		 	guard.setMobileNumber(123L);
		    guard.setEmailId("sampleTest@asp.com");
		    guard.setRole(Role.GUARD);
		    guard.setName("test");
	        Mockito.when(guardRepository.getById(guard.getId())).thenReturn(guard);
	        assertEquals(guard, guardService.deleteGuardById(guard.getId()));
	    }
	   
	    @Test
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
	    }
	    
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
}