package com.sprint;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint.entities.FlatDetails;
import com.sprint.entities.FlatRent;
import com.sprint.entities.Owner;
import com.sprint.entities.Rental;
import com.sprint.entities.Role;
import com.sprint.repositories.IFlatDetailsRepository;
import com.sprint.repositories.IOwnerRepository;
import com.sprint.services.FlatDetailsServiceImpl;
import com.sprint.services.OwnerServiceImpl;

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
		Owner owner=new Owner("havi","haviuser",90909090L,"havi@gmail.com","havi123",Role.GUARD);
		Owner owner1=new Owner("avi","aviuser",80909090L,"avi@gmail.com","avi123",Role.ADMIN);
	    FlatDetails flat1 = new FlatDetails();
	    flat1.setFlatNumber(101L);
	    flat1.setFloorNumber(1L);
	    flat1.setIsRented(true);
	    flat1.setOwner(owner);
	    
	    FlatDetails flat2 = new FlatDetails();
	     flat2.setFlatNumber(202L);
	    flat2.setFloorNumber(2L);
	    flat2.setIsRented(false);
	    flat2.setOwner(owner1);
	    
	    
	    Mockito.when(flatDetailsRepository.save(flat2)).thenReturn(flat2);
	    
	    assertEquals(flat1,flatDetailsService.addFlatDetails(flat1));
	    
	    
	}
	@Test
	public void getFlatDetailsByIdTest()
	{
		Owner owner=new Owner("iyan","iyanuser",10909090L,"iyan@gmail.com","iyan123",Role.ADMIN);
		Owner owner1=new Owner("maya","mayauser",20909090L,"maya@gmail.com","maya123",Role.GUARD);

		FlatDetails flat1 = new FlatDetails();
	    FlatDetails flat2 = new FlatDetails();
	    flat1.setFlatNumber(303L);
	    flat1.setFloorNumber(3L);
	    flat1.setIsRented(true);
	    flat1.setOwner(owner);
	    flat2.setFlatNumber(404L);
	    flat2.setFloorNumber(4L);
	    flat2.setIsRented(false);
	    flat2.setOwner(owner1);
		
		Mockito.when(flatDetailsRepository.getById(303L)).thenReturn(flat1);
		assertEquals(flat1,flatDetailsService.getFlatDetailsById(606L));
	}
	@Test
    public void getAllFlatDetailsTest() 
	{
		Owner owner=new Owner("kaya","kayauser",50909090L,"kaya@gmail.com","kaya123",Role.FLATOWNER);
		Owner owner1=new Owner("laya","layauser",60909090L,"laya@gmail.com","laya123",Role.GUARD);
		List<FlatDetails>list = new ArrayList<>();
        FlatDetails flat1 = new FlatDetails();
        flat1.setFlatNumber(505L);
        flat1.setFloorNumber(5L);
        flat1.setIsRented(true);
        flat1.setOwner(owner);
       
        FlatDetails flat2 = new FlatDetails();
        flat2.setFlatNumber(606L);
        flat2.setFloorNumber(6L);
        flat2.setIsRented(false);
        flat2.setOwner(owner1);
        
        list.add(flat1);
        list.add(flat2);
        Mockito.when(flatDetailsRepository.findAll()).thenReturn(list);
        assertEquals(list.size(), flatDetailsServiceImpl.listAllFlatDetails().size());
    }
	@Test
	public void updateFlatDetailsTest()
	{
		Owner owner=new Owner("kiran","kiranuser",70909090L,"kiran@gmail.com","kiran123",Role.GUARD);
		FlatDetails flat=new FlatDetails();
		flat.setFlatNumber(909L);
        flat.setFloorNumber(10L);
        flat.setIsRented(true);
        flat.setOwner(owner);

        Mockito.when(flatDetailsRepository.getById(909L)).thenReturn(flat);
        flat.setFloorNumber(9L);
        Mockito.when(flatDetailsRepository.save(flat)).thenReturn(flat);
        assertEquals(flat,flatDetailsService.updateFlatDetails(808L));
		
	}
	@Test
	public void deleteFlatDetailsTest()
	{
	   Owner owner=new Owner("jony","jonyuser",30909090L,"jony@gmail.com","jony123",Role.FLATOWNER);
	   FlatDetails flat1 = new FlatDetails();
	   flat1.setFlatNumber(707L);
	   flat1.setFloorNumber(7L);
	   flat1.setIsRented(true);
	   flat1.setOwner(owner);

	   flatDetailsRepository.save(flat1);
	   assertThat(flatDetailsRepository.findAll())
	            .hasSize(1)
	            .first()
	            .isEqualToComparingFieldByField(flat1);
	   flatDetailsRepository.deleteById(flat1.getFlatNumber());
	   assertThat(flatDetailsRepository.count()).isZero();
	}
	

}
