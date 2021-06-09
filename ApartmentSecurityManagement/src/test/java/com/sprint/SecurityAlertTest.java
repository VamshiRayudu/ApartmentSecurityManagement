package com.sprint;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint.entities.SecurityAlert;
import com.sprint.repositories.ISecurityAlertRepository;

import com.sprint.services.SecurityAlertServiceImpl;
@SpringBootTest
class SecurityAlertTest {


	@Mock

	ISecurityAlertRepository securityalertRepository= org.mockito.Mockito.mock(ISecurityAlertRepository.class);
	@InjectMocks

	SecurityAlertServiceImpl securityalertService = new SecurityAlertServiceImpl();



	@Test
	public void testGetSecurityAlertById() {

		SecurityAlert securityalert = new SecurityAlert();

		securityalert.setMessage("fire started on 6th floor");
		securityalert.setAlert("Emergency");
		securityalert.setDateTimeOfAlert(LocalDateTime.parse("2020-12-23T15:12:00"));

		Mockito.when(securityalertRepository.getById(securityalert.getId())).thenReturn(securityalert);

		SecurityAlert s = securityalertService.getSecurityAlertById(securityalert.getId());

		assertEquals(s,securityalert);

		verify(securityalertRepository, times(1)).getById(securityalert.getId());
	}
	@Test
	public void testAddSecurityAlert() {
		SecurityAlert  securityalert1 = new SecurityAlert();

		securityalert1.setMessage("just joking ");
		securityalert1.setAlert(" emergency");
		securityalert1.setDateTimeOfAlert(LocalDateTime.parse("2020-12-23T15:12:00"));


		Mockito.when(securityalertRepository.save( securityalert1)).thenReturn(securityalert1);

		securityalertService.addSecurityAlert(securityalert1);
		
		verify(securityalertRepository, times(1)).save(securityalert1);
	}
	@Test
	void testGetAllSecurityAlert() {

		List<SecurityAlert>list = new ArrayList<>();
		SecurityAlert securityalert2 = new SecurityAlert();

		securityalert2.setMessage("all members alert");
		securityalert2.setAlert("test");
		securityalert2.setDateTimeOfAlert(LocalDateTime.parse("2020-12-23T15:12:00"));

		SecurityAlert securityalert3 = new SecurityAlert();

		securityalert3.setMessage("fast");
		securityalert3.setAlert("test");
		securityalert3.setDateTimeOfAlert(LocalDateTime.parse("2020-12-23T15:12:00"));


		list.add(securityalert2);
		list.add(securityalert3);
		Mockito.when(securityalertRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), securityalertService.getSecurityAlertList().size());
	}

	@Test
	public void testdeleteById() {

		SecurityAlert securityalert = new SecurityAlert();
		securityalert.setMessage("all members alert");
		securityalert.setAlert("test");
		securityalert.setDateTimeOfAlert(LocalDateTime.parse("2020-12-23T15:12:00"));
		Mockito.when(securityalertRepository.findById(securityalert.getId())).thenReturn(Optional.of(securityalert));
		assertEquals(securityalert,  securityalertService.deleteSecurityAlertById(securityalert.getId()));
	}
}