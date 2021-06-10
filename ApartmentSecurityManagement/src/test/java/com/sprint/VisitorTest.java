package com.sprint;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.entities.Visitor;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.entities.FlatDetails;
import com.sprint.repositories.IVisitorRepository;
import com.sprint.services.VisitorServiceImpl;

 
@SpringBootTest
class VisitorTest {
       
    @Mock
    IVisitorRepository visitorRepository= org.mockito.Mockito.mock(IVisitorRepository.class);


    @InjectMocks
    VisitorServiceImpl visitorService = new VisitorServiceImpl();

	@Test
	public void addVisitorTest() {
		
		FlatDetails fd = new FlatDetails();
		
		fd.setFlatNumber(123L);
		
		fd.setFloorNumber(1L);
		
		Visitor visitor = new Visitor();
		
		visitor.setFlatDetails(fd);
		
		visitor.setId(1L);
		
		visitor.setInTime(LocalDateTime.parse("2020-12-23T12:12:00"));
		
		visitor.setOutTime(LocalDateTime.parse("2020-12-23T15:12:00"));
				
		visitor.setMobileNumber("21312");
		
		visitor.setVisitorName("Test");

		Mockito.when(visitorRepository.save(visitor)).thenReturn(visitor);
		
		visitorService.addVisitor(visitor);
		
		verify(visitorRepository, times(1)).save(visitor);

	} 

	@Test
	public void testGetUserById() throws RecordNotFoundException {

		FlatDetails fd = new FlatDetails();
		
		fd.setFlatNumber(123L);
		
		fd.setFloorNumber(1L);
		
		Visitor visitor = new Visitor();
		
		visitor.setFlatDetails(fd);
		
		visitor.setId(1L);
		
		visitor.setInTime(LocalDateTime.parse("2020-12-23T12:12:00"));
		
		visitor.setOutTime(LocalDateTime.parse("2020-12-23T15:12:00"));
		
		visitor.setMobileNumber("21312");
		
		visitor.setVisitorName("Test");
		
		Mockito.when(visitorRepository.save(visitor)).thenReturn(visitor);
		
		visitorService.addVisitor(visitor);
		
		Mockito.when(visitorRepository.getById(visitor.getId())).thenReturn(visitor);

		Visitor v = visitorService.getVisitorById(visitor.getId());
		
	    assertEquals(v,visitor);
	    
	    verify(visitorRepository, times(1)).getById(v.getId());
	}
	
	
	@Test
	public void deleteVisitor() throws RecordNotFoundException {
		FlatDetails fd = new FlatDetails();
		
		fd.setFlatNumber(123L);
		
		fd.setFloorNumber(1L);
		
		Visitor visitor = new Visitor();
		
		visitor.setFlatDetails(fd);
		
		visitor.setId(1L);
		
		visitor.setInTime(LocalDateTime.parse("2020-12-23T12:12:00"));
		
		visitor.setOutTime(LocalDateTime.parse("2020-12-23T15:12:00"));
		
		visitor.setMobileNumber("21312");
		
		visitor.setVisitorName("Test");
		
        Mockito.when(visitorRepository.findById(visitor.getId())).thenReturn(Optional.of(visitor));
        
        assertEquals(visitor, visitorService.deleteVisitorById(visitor.getId()));
	}

}