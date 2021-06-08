package com.sprint;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint.entities.Attendance;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;
import com.sprint.entities.Role;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IDomesticHelpRepository;
import com.sprint.services.AdminServiceImpl;
import com.sprint.services.DomesticHelpService;

class DomesticHelpTest {

	
	@Mock
	IDomesticHelpRepository domesticHelpRepository= org.mockito.Mockito.mock(IDomesticHelpRepository.class);

	@InjectMocks
	DomesticHelpService domesticService = new DomesticHelpService();
	
	
	
	@Test
	void getDomesticHelpListTest() {
		
		List<Attendance> l1 = new ArrayList<>();
		Attendance a1 = new Attendance();
		a1.setDateOfAttendance(LocalDate.parse("2021-06-06"));
		a1.setInTime(LocalDateTime.parse("2021-06-06T12:12:00"));
		a1.setOutTime(LocalDateTime.parse("2021-06-06T12:16:00"));
		l1.add(a1);
		
		
		List<DomesticHelp> list = new ArrayList<>();
		DomesticHelp domesticHelp1 = new DomesticHelp();
		domesticHelp1.setName("Ravi");
		domesticHelp1.setAadharId("123456789123");
		domesticHelp1.setMobileNumber(123L);
		domesticHelp1.setHelpType(DomesticHelpType.COOKING);
		domesticHelp1.setAttendance(l1);
		
		DomesticHelp domesticHelp2 = new DomesticHelp();
		domesticHelp2.setName("Ravi");
		domesticHelp2.setAadharId("123456789123");
		domesticHelp2.setMobileNumber(123L);
		domesticHelp2.setHelpType(DomesticHelpType.COOKING);
		domesticHelp2.setAttendance(l1);
		
		list.add(domesticHelp1);
		list.add(domesticHelp2);
		Mockito.when(domesticHelpRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), domesticService.getDomesticHelpList().size());
	}
	
	
	@Test
	void getDomesticHelpByIdTest() {
		DomesticHelp domesticHelp1 = new DomesticHelp();
		domesticHelp1.setId(1L);
		domesticHelp1.setName("Ravi");
		domesticHelp1.setAadharId("123456789123");
		domesticHelp1.setMobileNumber(123L);
		domesticHelp1.setHelpType(DomesticHelpType.COOKING);
		
		Mockito.when(domesticHelpRepository.getById(1L)).thenReturn(domesticHelp1);
		assertEquals(domesticHelp1, domesticService.getDomesticHelpById(1L));
		
	}
	
	
	@Test
	void addDomesticHelpTest() {
		DomesticHelp domesticHelp1 = new DomesticHelp();
		domesticHelp1.setName("Ravi");
		domesticHelp1.setAadharId("123456789123");
		domesticHelp1.setMobileNumber(123L);
		domesticHelp1.setHelpType(DomesticHelpType.COOKING);
		
		Mockito.when(domesticHelpRepository.save(domesticHelp1)).thenReturn(domesticHelp1);
		assertEquals(domesticHelp1, domesticService.addDomesticHelp(domesticHelp1));
		
	}
	
	
	@Test
	void updateDomesticHelpByIdTest() {
		
		List<Attendance> l1 = new ArrayList<>();
		Attendance a1 = new Attendance();
		a1.setDateOfAttendance(LocalDate.parse("2021-06-06"));
		a1.setInTime(LocalDateTime.parse("2021-06-06T12:12:00"));
		a1.setOutTime(LocalDateTime.parse("2021-06-06T12:16:00"));
		l1.add(a1);
		
		DomesticHelp domesticHelp1 = new DomesticHelp();
		domesticHelp1.setId(1L);
		domesticHelp1.setName("Ravi");
		domesticHelp1.setAadharId("123456789123");
		domesticHelp1.setMobileNumber(123L);
		domesticHelp1.setHelpType(DomesticHelpType.COOKING);
		domesticHelp1.setAttendance(l1);
		
		Mockito.when(domesticHelpRepository.getById(1L)).thenReturn(domesticHelp1);
		
		domesticHelp1.setMobileNumber(456L);
		
		Attendance a2 = new Attendance();
		a2.setDateOfAttendance(LocalDate.parse("2021-05-06"));
		a2.setInTime(LocalDateTime.parse("2021-05-06T12:12:00"));
		a2.setOutTime(LocalDateTime.parse("2021-05-06T12:16:00"));
		
		domesticHelp1.getAttendance().add(a2);
		
		Mockito.when(domesticHelpRepository.save(domesticHelp1)).thenReturn(domesticHelp1);
		
		assertEquals(domesticHelp1, domesticService.updateDomesticHelpById(1L));
		
	}
	
	

	
}
