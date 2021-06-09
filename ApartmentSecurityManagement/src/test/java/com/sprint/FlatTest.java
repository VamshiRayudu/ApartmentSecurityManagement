package com.sprint;
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
import com.sprint.repositories.IFlatDetailsRepository;
import com.sprint.services.FlatDetailsServiceImpl;
@SpringBootTest
class FlatTest {

	@Autowired
	private FlatDetailsServiceImpl flatDetailsServiceImpl; 
	
	@Mock

	IFlatDetailsRepository flatDetailsRepository= org.mockito.Mockito.mock(IFlatDetailsRepository.class);

	@InjectMocks

	FlatDetailsServiceImpl flatDetailsService = new FlatDetailsServiceImpl();
	
	@Test
	public void addFlatDetailsTest()
	{
		Owner owner1=new Owner("havi","haviuser",90909090L,"havi@gmail.com","havi123",Role.GUARD);
		FlatDetails flat1 = new FlatDetails(101L,1L,true,owner1);
	    Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
	    flatDetailsService.addFlatDetails(flat1);
	    assertEquals(1L,flat1.getFloorNumber());
	 }
	
	@Test
	public void getFlatDetailsByIdTest()
	{
		Owner owner1=new Owner("iyan","iyanuser",10909090L,"iyan@gmail.com","iyan123",Role.ADMIN);
		FlatDetails flat1 = new  FlatDetails(101L,1L,true,owner1);
		Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
		flatDetailsService.addFlatDetails(flat1);
		Mockito.when(flatDetailsRepository.findById(flat1.getFlatNumber())).thenReturn(Optional.of(flat1));
		FlatDetails f = flatDetailsService.getFlatDetailsById(flat1.getFlatNumber());
		assertEquals(f,flat1);
		verify(flatDetailsRepository, times(1)).getById(flat1.getFlatNumber()); 		
	}
	
	
	@Test
    public void getAllFlatDetailsTest() 
	{
		List<FlatDetails> list=new ArrayList<FlatDetails>();
		Owner owner1=new Owner("iyan","iyanuser",10909090L,"iyan@gmail.com","iyan123",Role.ADMIN);
		Owner owner2=new Owner("maya","mayauser",20909090L,"maya@gmail.com","maya123",Role.GUARD);

		FlatDetails flat1 = new FlatDetails(101L,1L,true,owner1);
		FlatDetails flat2 = new FlatDetails(202L,2L,false,owner2);
		
		list.add(flat1);
		list.add(flat2);
		flatDetailsRepository.save(flat1);
		flatDetailsRepository.save(flat2);
		Mockito.when(flatDetailsRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), flatDetailsService.listAllFlatDetails().size());
	}
    
	@Test
	public void updateFlatDetailsTest()
	{
		Owner owner1=new Owner("iyan","iyanuser",10909090L,"iyan@gmail.com","iyan123",Role.ADMIN);
		FlatDetails flat1 = new FlatDetails(101L,1L,true,owner1);
		Mockito.when(flatDetailsRepository.save(flat1)).thenReturn(flat1);
		flatDetailsService.addFlatDetails(flat1);
		Mockito.when(flatDetailsRepository.findById(flat1.getFlatNumber())).thenReturn(Optional.of(flat1));
		
	}
}