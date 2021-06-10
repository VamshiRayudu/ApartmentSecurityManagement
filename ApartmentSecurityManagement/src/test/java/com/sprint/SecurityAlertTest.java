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

import com.sprint.entities.Admin;
import com.sprint.entities.FlatDetails;
import com.sprint.entities.Owner;
import com.sprint.entities.Role;
import com.sprint.entities.SecurityAlert;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.repositories.ISecurityAlertRepository;

import com.sprint.services.SecurityAlertServiceImpl;
@SpringBootTest
class SecurityAlertTest {


	@Mock

	ISecurityAlertRepository securityalertRepository= org.mockito.Mockito.mock(ISecurityAlertRepository.class);
	@InjectMocks

	SecurityAlertServiceImpl securityalertService;  


	@Test
	public void testGetSecurityAlertById() throws RecordNotFoundException {

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
	public void testAddSecurityAlert() throws DuplicateRecordException {
		SecurityAlert  securityalert = new SecurityAlert();

		securityalert.setMessage("justjoking");
		securityalert.setAlert("emergency");
		securityalert.setDateTimeOfAlert(LocalDateTime.parse("2020-12-23T15:12:00"));


		Mockito.when(securityalertRepository.save( securityalert)).thenReturn(securityalert);

		SecurityAlert s = securityalertService.addSecurityAlert(securityalert);

		assertEquals("justjoking",s.getMessage());
		assertEquals("emergency",s.getAlert());
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
	public void testdeleteById() throws RecordNotFoundException {

		SecurityAlert securityalert = new SecurityAlert();
		securityalert.setMessage("all members alert");
		securityalert.setAlert("test");
		securityalert.setDateTimeOfAlert(LocalDateTime.parse("2020-12-23T15:12:00"));
		Mockito.when(securityalertRepository.findById(securityalert.getId())).thenReturn(Optional.of(securityalert));
		assertEquals(securityalert,  securityalertService.deleteSecurityAlertById(securityalert.getId()));
	}

	@Test
	void testUpdateSecurityAlert() throws RecordNotFoundException {
		SecurityAlert  securityalert  = new SecurityAlert();



		securityalert .setMessage("just joking");
		securityalert .setAlert("emergency");
		securityalert.setDateTimeOfAlert(LocalDateTime.parse("2020-12-23T15:12:00"));

		Mockito.when(securityalertRepository.save( securityalert)).thenReturn( securityalert );
		securityalertService.updateSecurityAlert ( securityalert );
		assertEquals("just joking",  securityalert .getMessage());
	}

}