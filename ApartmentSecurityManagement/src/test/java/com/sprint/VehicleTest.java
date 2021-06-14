package com.sprint;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.entities.FlatDetails;
import com.sprint.entities.Owner;
import com.sprint.entities.Role;
import com.sprint.entities.Vehicle;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IVehicleRepository;
import com.sprint.services.IVehicleService;
import com.sprint.services.VehicleServiceImpl;

/**
 * @author VISHNU KUMAR
 *
 */
@SpringBootTest
class VehicleTest {

	@Autowired
	private VehicleServiceImpl vehicleServiceImpl;

	@Mock

	IVehicleRepository IVehicleRepository = org.mockito.Mockito.mock(IVehicleRepository.class);

	@InjectMocks

	VehicleServiceImpl vehicleService = new VehicleServiceImpl();

	@Test

	public void addVehicleTest() {
		Vehicle a = new Vehicle();
		FlatDetails fd = new FlatDetails();
		fd.setFlatNumber(123L);
		fd.setFloorNumber(1L);
		Owner owner1 = new Owner();
		owner1.setMobileNumber(123L);
		owner1.setEmailId("sampleTest@asp.com");
		owner1.setRole(Role.FLATOWNER);
		owner1.setName("test");
		a.setId(134l);
		a.setNumberPlate("tn45");
		a.setVehicleColour("blue");
		a.setOwner(owner1);
		a.setFlatdetails(fd);
		Mockito.when(IVehicleRepository.save(a)).thenReturn(a);
		vehicleService.addVehicle(a);
		verify(IVehicleRepository, times(1)).save(a);

	}

	@Test
	public void deleteVehicleById() throws RecordNotFoundException {
		Vehicle a3 = new Vehicle();
		FlatDetails fd = new FlatDetails();
		fd.setFlatNumber(123L);
		fd.setFloorNumber(1L);
		Owner owner1 = new Owner();
		owner1.setMobileNumber(123L);
		owner1.setEmailId("sampleTest@asp.com");
		owner1.setRole(Role.FLATOWNER);
		owner1.setName("test");
		a3.setId(123L);
		a3.setNumberPlate("tn68");
		a3.setVehicleColour("Black");
		a3.setOwner(owner1);
		a3.setFlatdetails(fd);
		Mockito.when(IVehicleRepository.findById(a3.getId())).thenReturn(Optional.of(a3));
		assertEquals(a3, vehicleService.deleteVehicleById(a3.getId()));

	}

	@Test
	void testGetAllVehiclesList() {
		List<Vehicle> list = new ArrayList<>();
		FlatDetails fd = new FlatDetails();
		fd.setFlatNumber(123L);
		fd.setFloorNumber(1L);
		Owner owner1 = new Owner();
		owner1.setMobileNumber(123L);
		owner1.setEmailId("sampleTest@asp.com");
		owner1.setRole(Role.FLATOWNER);
		owner1.setName("test");
		Vehicle a1 = new Vehicle();
		a1.setId(134l);
		a1.setNumberPlate("tn45");
		a1.setVehicleColour("blue");
		a1.setOwner(owner1);
		a1.setFlatdetails(fd);
		Vehicle a5 = new Vehicle();
		a5.setId(134l);
		a5.setNumberPlate("tn45");
		a5.setVehicleColour("blue");
		a5.setOwner(owner1);
		a5.setFlatdetails(fd);
		list.add(a1);
		list.add(a5);
		Mockito.when(IVehicleRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), vehicleService.getAllVehicles().size());
	}

	@Test
	void testGetVehiclesById() throws RecordNotFoundException {

		FlatDetails fd = new FlatDetails();
		fd.setFlatNumber(123L);
		fd.setFloorNumber(1L);
		Owner owner1 = new Owner();
		owner1.setMobileNumber(123L);
		owner1.setEmailId("sampleTest@asp.com");
		owner1.setRole(Role.FLATOWNER);
		owner1.setName("test");
		Vehicle a1 = new Vehicle();
		a1.setId(134l);
		a1.setNumberPlate("tn45");
		a1.setVehicleColour("blue");
		a1.setOwner(owner1);
		a1.setFlatdetails(fd);
		Mockito.when(IVehicleRepository.getById(a1.getId())).thenReturn(a1);
		Vehicle a = vehicleService.getVehiclesById(a1.getId());
		assertEquals(a, a1);
		verify(IVehicleRepository, times(1)).getById(a1.getId());

	}

	@Test
	public void testNotDeleteVehicleById() throws UserNotFoundException, RecordNotFoundException {
		Vehicle a3 = new Vehicle();
		FlatDetails fd = new FlatDetails();
		fd.setFlatNumber(123L);
		fd.setFloorNumber(1L);
		Owner owner1 = new Owner();
		owner1.setMobileNumber(123L);
		owner1.setEmailId("sampleTest@asp.com");
		owner1.setRole(Role.FLATOWNER);
		owner1.setName("test");
		a3.setId(123L);
		a3.setNumberPlate("tn68");
		a3.setVehicleColour("Black");
		a3.setOwner(owner1);
		a3.setFlatdetails(fd);
		Vehicle a4 = new Vehicle();
		a4.setId(13L);
		a4.setNumberPlate("tn68");
		a4.setVehicleColour("Black");
		a4.setOwner(owner1);
		a4.setFlatdetails(fd);
		Mockito.when(IVehicleRepository.findById(a3.getId())).thenReturn(Optional.of(a3));
		assertEquals(a4, vehicleService.deleteVehicleById(a3.getId()));
	}

	@Test
	public void addNotVehicleTest() {
		Vehicle a = new Vehicle();
		FlatDetails fd = new FlatDetails();
		fd.setFlatNumber(123L);
		fd.setFloorNumber(1L);
		Owner owner1 = new Owner();
		owner1.setMobileNumber(123L);
		owner1.setEmailId("sampleTest@asp.com");
		owner1.setRole(Role.FLATOWNER);
		owner1.setName("test");
		Owner owner2 = new Owner();
		owner2.setMobileNumber(123L);
		owner2.setEmailId("sampleTest@asp.com");
		owner2.setRole(Role.FLATOWNER);
		owner2.setName("test");
		a.setId(134l);
		a.setNumberPlate("tn45");
		a.setVehicleColour("blue");
		a.setOwner(owner1);
		a.setFlatdetails(fd);
		Mockito.when(IVehicleRepository.save(a)).thenReturn(a);
		Vehicle v = vehicleService.addVehicle(a);
		verify(IVehicleRepository, times(1)).save(a);
		assertEquals(v.getOwner(), owner2);
	}

	@Test
	public void testUpdateVehicle() throws UserNotFoundException, RecordNotFoundException {
		FlatDetails fd = new FlatDetails();
		fd.setFlatNumber(123L);
		fd.setFloorNumber(1L);
		Owner owner1 = new Owner();
		owner1.setMobileNumber(123L);
		owner1.setEmailId("sampleTest@asp.com");
		owner1.setRole(Role.FLATOWNER);
		owner1.setName("test");
		Vehicle a1 = new Vehicle();
		a1.setId(134l);
		a1.setNumberPlate("tn45");
		a1.setVehicleColour("blue");
		a1.setOwner(owner1);
		a1.setFlatdetails(fd);
		Mockito.when(IVehicleRepository.save(a1)).thenReturn(a1);
		assertEquals("tn45", a1.getNumberPlate());
	}

	@Test
	public void testNotUpdateVehicle() throws UserNotFoundException, RecordNotFoundException {
		FlatDetails fd = new FlatDetails();
		fd.setFlatNumber(123L);
		fd.setFloorNumber(1L);
		Owner owner1 = new Owner();
		owner1.setMobileNumber(123L);
		owner1.setEmailId("sampleTest@asp.com");
		owner1.setRole(Role.FLATOWNER);
		owner1.setName("test");
		Vehicle a1 = new Vehicle();
		a1.setId(134l);
		a1.setNumberPlate("tn45");
		a1.setVehicleColour("blue");
		a1.setOwner(owner1);
		a1.setFlatdetails(fd);
		Mockito.when(IVehicleRepository.save(a1)).thenReturn(a1);
		assertEquals("tn44", a1.getNumberPlate());
	}
}