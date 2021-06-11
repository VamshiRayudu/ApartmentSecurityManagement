package com.sprint;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.entities.Attendance;
import com.sprint.entities.DeliveryStatus;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;
import com.sprint.entities.FlatDetails;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IDomesticHelpRepository;
import com.sprint.services.AdminServiceImpl;
import com.sprint.services.DomesticHelpServiceImpl;

@SpringBootTest
class DomesticHelpTest {

	
	@Mock
	IDomesticHelpRepository domesticHelpRepository= org.mockito.Mockito.mock(IDomesticHelpRepository.class);

	@InjectMocks
	DomesticHelpServiceImpl domesticService = new DomesticHelpServiceImpl();
	
	
	
	@Test
	void getDomesticHelpListTest() {
		
		List<Attendance> attendanceList = new ArrayList<>();
		Attendance attendance = new Attendance(LocalDate.parse("2021-06-06") , LocalDateTime.parse("2021-06-06T12:12:00") , 
							LocalDateTime.parse("2021-06-06T12:16:00") , 1L , true);
		attendanceList.add(attendance);
		
		List<FlatDetails> flatDetailsList = new ArrayList<>();
		FlatDetails fDetails1 = new FlatDetails(606L , 6L);
		FlatDetails fDetails2 = new FlatDetails(506L , 5L);
		flatDetailsList.add(fDetails1);
		flatDetailsList.add(fDetails2);
		
		List<DomesticHelp> domesticHelpList = new ArrayList<>();
		DomesticHelp domesticHelp1 = new DomesticHelp(attendanceList , DomesticHelpType.COOKING, "Raju" , "123456" , 12345L , flatDetailsList);
		DomesticHelp domesticHelp2 = new DomesticHelp(attendanceList , DomesticHelpType.PLUMBING, "Rakesh" , "1234" , 1234L , flatDetailsList);
		domesticHelpList.add(domesticHelp1);
		domesticHelpList.add(domesticHelp2);
		
		
		Mockito.when(domesticHelpRepository.findAll()).thenReturn(domesticHelpList);
		assertEquals(domesticHelpList.size(), domesticService.getDomesticHelpList().size());
		
	}
	
	
	@Test
	void getDomesticHelpByIdTest() throws DuplicateRecordException, UserNotFoundException {
		
		List<Attendance> attendanceList = new ArrayList<>();
		Attendance attendance = new Attendance(LocalDate.parse("2021-06-06") , LocalDateTime.parse("2021-06-06T12:12:00") , 
							LocalDateTime.parse("2021-06-06T12:16:00") , 1L , true);
		attendanceList.add(attendance);
		
		List<FlatDetails> flatDetailsList = new ArrayList<>();
		FlatDetails fDetails1 = new FlatDetails(606L , 6L);
		FlatDetails fDetails2 = new FlatDetails(506L , 5L);
		flatDetailsList.add(fDetails1);
		flatDetailsList.add(fDetails2);
		
		DomesticHelp domesticHelp = new DomesticHelp(attendanceList , DomesticHelpType.COOKING, "Raju" , "123456" , 12345L , flatDetailsList);
		
		Mockito.when(domesticHelpRepository.save(domesticHelp)).thenReturn(domesticHelp);
		domesticService.addDomesticHelp(domesticHelp);
		Mockito.when(domesticHelpRepository.findById(domesticHelp.getId())).thenReturn(Optional.of(domesticHelp));
		DomesticHelp dh = domesticService.getDomesticHelpById(domesticHelp.getId());
		assertEquals(dh,domesticHelp);
		
	}
	
	
	@Test
	void addDomesticHelpTest() throws DuplicateRecordException {
		
		List<Attendance> attendanceList = new ArrayList<>();
		Attendance attendance = new Attendance(LocalDate.parse("2021-05-06") , LocalDateTime.parse("2021-05-06T12:13:00") , 
							LocalDateTime.parse("2021-05-06T12:16:00") , 6L , true);
		attendanceList.add(attendance);
		
		List<FlatDetails> flatDetailsList = new ArrayList<>();
		FlatDetails fDetails1 = new FlatDetails(106L , 1L);
		FlatDetails fDetails2 = new FlatDetails(206L , 2L);
		flatDetailsList.add(fDetails1);
		flatDetailsList.add(fDetails2);
		
		DomesticHelp domesticHelp = new DomesticHelp(attendanceList , DomesticHelpType.HOUSEKEEPING, "Raghu" , "12345678" , 12345678L , flatDetailsList);
		
		Mockito.when(domesticHelpRepository.save(domesticHelp)).thenReturn(domesticHelp);
		domesticService.addDomesticHelp(domesticHelp);
		assertEquals("Raghu" , domesticHelp.getName());
		
	}
	
	
	@Test
	void updateDomesticHelpTest() throws UserNotFoundException {
		
		List<Attendance> attendanceList = new ArrayList<>();
		Attendance attendance = new Attendance(LocalDate.parse("2021-03-06") , LocalDateTime.parse("2021-03-06T12:13:00") , 
							LocalDateTime.parse("2021-03-06T12:16:00") , 3L , true);
		attendanceList.add(attendance);
		
		List<FlatDetails> flatDetailsList = new ArrayList<>();
		FlatDetails fDetails1 = new FlatDetails(603L , 6L);
		FlatDetails fDetails2 = new FlatDetails(503L , 5L);
		flatDetailsList.add(fDetails1);
		flatDetailsList.add(fDetails2);
		
		DomesticHelp domesticHelp = new DomesticHelp(attendanceList , DomesticHelpType.COOKING, "Ravi" , "123" , 123L , flatDetailsList);
		
		domesticHelp.setName("Rakesh");
		Mockito.when(domesticHelpRepository.save(domesticHelp)).thenReturn(domesticHelp);
		domesticService.updateDomesticHelp(domesticHelp);
		assertEquals("Rakesh" , domesticHelp.getName());
		
	}
	
	
	@Test
	void updateDomesticHelpByIdTest() throws DuplicateRecordException, UserNotFoundException {
		
		List<Attendance> attendanceList = new ArrayList<>();
		Attendance attendance = new Attendance(LocalDate.parse("2021-04-06") , LocalDateTime.parse("2021-04-06T12:13:00") , 
							LocalDateTime.parse("2021-04-06T12:16:00") , 6L , true);
		attendanceList.add(attendance);
		
		List<FlatDetails> flatDetailsList = new ArrayList<>();
		FlatDetails fDetails1 = new FlatDetails(306L , 3L);
		FlatDetails fDetails2 = new FlatDetails(406L , 4L);
		flatDetailsList.add(fDetails1);
		flatDetailsList.add(fDetails2);
		
		DomesticHelp domesticHelp = new DomesticHelp(1L,attendanceList , DomesticHelpType.HOUSEKEEPING, "Rakesh" , "123456789" , 123456789L , flatDetailsList);
		
		
		Mockito.when(domesticHelpRepository.save(domesticHelp)).thenReturn(domesticHelp);
		domesticService.addDomesticHelp(domesticHelp);
		Mockito.when(domesticHelpRepository.findById(domesticHelp.getId())).thenReturn(Optional.of(domesticHelp));
		
		domesticHelp.setHelpType(DomesticHelpType.WASHING);
		Mockito.when(domesticHelpRepository.save(domesticHelp)).thenReturn(domesticHelp);
		assertThat(domesticService.updateDomesticHelpById(domesticHelp.getId(), DomesticHelpType.WASHING, DomesticHelpType.HOUSEKEEPING)).isEqualTo(domesticHelp);
		
		 
		}
	
	
	
	
	
	
}