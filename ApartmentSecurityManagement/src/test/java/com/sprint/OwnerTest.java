package com.sprint;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.entities.Admin;
import com.sprint.entities.FlatDetails;
import com.sprint.entities.Owner;
import com.sprint.entities.Role;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IOwnerRepository;
import com.sprint.services.AdminServiceImpl;
import com.sprint.services.OwnerServiceImpl;

@SpringBootTest
public class OwnerTest {


	@Mock

	IOwnerRepository ownerRepository= org.mockito.Mockito.mock(IOwnerRepository.class);

	@InjectMocks

	OwnerServiceImpl ownerService; 



	@Test
	public void testAddOwner() throws DuplicateRecordException {

		Owner owner = new Owner("reddy","harsha",12223L,"farakhan@gmail.com","password",Role.FLATOWNER);
		Mockito.when(ownerRepository.save(owner)).thenReturn(owner);
		ownerService.addOwner(owner);
		assertEquals("reddy",owner.getUserName());
		assertEquals("password",owner.getPassword());
	}


	@Test
	public void testGetOwnerById() throws UserNotFoundException {

		Owner owner = new Owner();
		owner.setMobileNumber(123L);
		owner.setEmailId("sampleTest@asp.com");
		owner.setRole(Role.FLATOWNER);
		owner.setName("test");
		owner.setUserName("demo");


		Mockito.when(ownerRepository.getById(owner.getId())).thenReturn(owner);

		Owner a = ownerService.getOwnerById(owner.getId());

		assertEquals(a,owner);

		verify(ownerRepository, times(1)).getById(owner.getId());
	}


	@Test
	public void deleteOwnertest() throws DuplicateRecordException, UserNotFoundException {

		Owner owner = new Owner(15L,"simha","harsha",12223L,"pabbavivek@gmail.com","password",Role.FLATOWNER);
		Mockito.when(ownerRepository.findById(owner.getId())).thenReturn(Optional.of(owner));
		ownerService.addOwner(owner);
		assertEquals(owner,ownerService.deleteOwner(owner));
	}





	@Test
	void testGetAllOwner() {
		List<Owner>list = new ArrayList<>();
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
		list.add(owner1);
		list.add(owner2);
		Mockito.when(ownerRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), ownerService.getAllOwnerList().size());
	}

	@Test
	public void updateOwnerTest() throws DuplicateRecordException
	{
		Owner owner1=new Owner("iyan","iyanuser",10909090L,"iyan@gmail.com","iyan123",Role.FLATOWNER);
		Owner owner  = new 	Owner();
		Mockito.when(ownerRepository.save(owner)).thenReturn(owner);
		ownerService.addOwner(owner);
		Mockito.when(ownerRepository.findById(owner.getMobileNumber())).thenReturn(Optional.of(owner));

	}
	@Test
	void testUpdateOwnerById() throws UserNotFoundException {
		Owner owner = new Owner(1L,"vamshi","rayudu",12223L,"sampleTest@asp.com","password",Role.FLATOWNER);
		Mockito.when(ownerRepository.findById( owner.getId())).thenReturn(Optional.of( owner));
		Owner upPass =  ownerService. updateOwnerById( owner.getId(),  owner.getPassword(), "password2");
		assertEquals("password2", upPass.getPassword());
	}



	@Test
	public void testDeleteById() throws UserNotFoundException {
		Owner owner = new Owner(1L,"harsha","simha",12223L,"pabba@gmail.com","password",Role.FLATOWNER);
		Mockito.when(ownerRepository.findById(owner.getId())).thenReturn(Optional.of(owner));
		assertEquals(owner,  ownerService.deleteOwnerById(owner.getId()));
	}

}