package com.sprint;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.entities.FlatDetails;
import com.sprint.entities.Owner;
import com.sprint.entities.Role;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.repositories.IFlatDetailsRepository;
import com.sprint.services.FlatDetailsServiceImpl;

@SpringBootTest
class FlatTest {

	@Mock

	IFlatDetailsRepository flatDetailsRepository = org.mockito.Mockito.mock(IFlatDetailsRepository.class);

	@InjectMocks

	FlatDetailsServiceImpl flatDetailsService = new FlatDetailsServiceImpl();

	@Test
	public void addFlatDetailsTest() throws DuplicateRecordException {
		Owner owner1 = new Owner("havi", "haviuser", 90909090L, "havi@gmail.com", "havi123", Role.GUARD);
		FlatDetails flat1 = new FlatDetails(101L, 1L, true, owner1);
		Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
		flatDetailsService.addFlatDetails(flat1);
		assertEquals(1L, flat1.getFloorNumber());
	}

	@Test
	public void getFlatDetailsByIdTest() throws DuplicateRecordException, RecordNotFoundException {
		Owner owner1 = new Owner("iyan", "iyanuser", 10909090L, "iyan@gmail.com", "iyan123", Role.ADMIN);

		FlatDetails flat1 = new FlatDetails(101L, 1L, true, owner1);
		Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
		flatDetailsService.addFlatDetails(flat1);
		Mockito.when(flatDetailsRepository.findById(flat1.getFlatNumber())).thenReturn(Optional.of(flat1));
		FlatDetails f = flatDetailsService.getFlatDetailsById(flat1.getFlatNumber());
		assertEquals(f, flat1);

	}

	@Test
	public void getAllFlatDetailsTest() {
		List<FlatDetails> list = new ArrayList<FlatDetails>();
		Owner owner1 = new Owner("iyan", "iyanuser", 10909090L, "iyan@gmail.com", "iyan123", Role.ADMIN);
		Owner owner2 = new Owner("maya", "mayauser", 20909090L, "maya@gmail.com", "maya123", Role.GUARD);

		FlatDetails flat1 = new FlatDetails(101L, 1L, true, owner1);
		FlatDetails flat2 = new FlatDetails(202L, 2L, false, owner2);

		list.add(flat1);
		list.add(flat2);
		flatDetailsRepository.save(flat1);
		flatDetailsRepository.save(flat2);
		Mockito.when(flatDetailsRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), flatDetailsService.listAllFlatDetails().size());
	}

	@Test
	public void updateFlatDetailsTest() throws RecordNotFoundException, DuplicateRecordException {
		Owner owner1 = new Owner("iyan", "iyanuser", 10909090L, "iyan@gmail.com", "iyan123", Role.ADMIN);
		Owner owner2 = new Owner("riyan", "riyanuser", 20909090L, "riyan@gmail.com", "riyan123", Role.GUARD);

		FlatDetails flat1 = new FlatDetails(101L, 1L, true, owner1);
		Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
		flatDetailsService.addFlatDetails(flat1);
		Mockito.when(flatDetailsRepository.findById(flat1.getFlatNumber())).thenReturn(Optional.of(flat1));
		flat1.setOwner(owner2);
		Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
		assertThat(flatDetailsService.updateFlatDetails(flat1.getFlatNumber(), owner1)).isEqualTo(flat1);

	}

	@Test
	public void notAddFlatDetailsTest() throws DuplicateRecordException {
		Owner owner1 = new Owner("havi", "haviuser", 90909090L, "havi@gmail.com", "havi123", Role.GUARD);
		Owner owner2 = new Owner("anvi", "anviuser", 90809090L, "anvi@gmail.com", "anvi123", Role.ADMIN);
		FlatDetails flat1 = new FlatDetails(101L, 1L, true, owner1);
		FlatDetails flat2 = new FlatDetails(102L, 2L, true, owner2);
		Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
		flatDetailsService.addFlatDetails(flat1);
		assertEquals(flat1, flatDetailsService.addFlatDetails(flat2));
	}

	@Test
	public void notUpdateFlatDetailsTest() throws RecordNotFoundException, DuplicateRecordException {
		Owner owner1 = new Owner("iyan", "iyanuser", 10909090L, "iyan@gmail.com", "iyan123", Role.ADMIN);
		Owner owner2 = new Owner("riyan", "riyanuser", 20909090L, "riyan@gmail.com", "riyan123", Role.GUARD);

		FlatDetails flat1 = new FlatDetails(101L, 1L, true, owner1);

		Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
		flatDetailsService.addFlatDetails(flat1);
		Mockito.when(flatDetailsRepository.findById(flat1.getFlatNumber())).thenReturn(Optional.of(flat1));
		flat1.setOwner(owner1);
		Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
		assertThat(flatDetailsService.updateFlatDetails(flat1.getFlatNumber(), owner1)).isEqualTo(flat1);
		assertEquals(flat1.getOwner().getName(), owner2.getName());

	}
}