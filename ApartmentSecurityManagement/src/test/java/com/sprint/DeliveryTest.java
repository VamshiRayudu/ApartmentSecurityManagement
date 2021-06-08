package com.sprint;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sprint.entities.Delivery;
import com.sprint.entities.DeliveryStatus;
import com.sprint.entities.FlatDetails;
import com.sprint.entities.Guard;
import com.sprint.repositories.IDeliveryRepository;
import com.sprint.services.DeliveryServiceImpl;


class DeliveryTest {

	@Mock
	IDeliveryRepository deliveryRepository= org.mockito.Mockito.mock(IDeliveryRepository.class);

	@InjectMocks
	DeliveryServiceImpl deliveryService = new DeliveryServiceImpl();
	
	
	@Test
	void getDeliveryListTest() {
		
		
		
		FlatDetails fd1 = new FlatDetails();
		fd1.setFlatNumber(123L);
		fd1.setFloorNumber(6L);
		
		FlatDetails fd2 = new FlatDetails();
		fd2.setFlatNumber(456L);
		fd2.setFloorNumber(2L);
		
		List<Delivery> list = new ArrayList<>();
		Delivery delivery1 = new Delivery();
		delivery1.setFlatDetails(fd1);
		delivery1.setDeliveryDateTime(LocalDateTime.parse("2021-06-06T12:12:00"));
		delivery1.setStatus(DeliveryStatus.RECEIVED);
		
		Delivery delivery2 = new Delivery();
		delivery2.setFlatDetails(fd2);
		delivery2.setDeliveryDateTime(LocalDateTime.parse("2021-06-06T12:16:00"));
		delivery2.setStatus(DeliveryStatus.PICKEDUP);
		
		list.add(delivery1);
		list.add(delivery2);
		Mockito.when(deliveryRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), deliveryService.getDeliveryList().size());
	}
	
	
	@Test
	void getDeliveryTest() {
		
		FlatDetails fd1 = new FlatDetails();
		fd1.setFlatNumber(123L);
		fd1.setFloorNumber(6L);
		
		Delivery delivery1 = new Delivery();
		delivery1.setDeliveryId(1L);
		delivery1.setFlatDetails(fd1);
		delivery1.setDeliveryDateTime(LocalDateTime.parse("2021-06-06T12:12:00"));
		delivery1.setStatus(DeliveryStatus.RECEIVED);
		
		Mockito.when(deliveryRepository.getById(1L)).thenReturn(delivery1);
		assertEquals(delivery1, deliveryService.getDelivery(1L));
	}
	
	
	@Test
	void getaddDeliveryTest() {
		
		FlatDetails fd1 = new FlatDetails();
		fd1.setFlatNumber(123L);
		fd1.setFloorNumber(6L);
		
		Delivery delivery1 = new Delivery();
		delivery1.setFlatDetails(fd1);
		delivery1.setDeliveryDateTime(LocalDateTime.parse("2021-06-06T12:12:00"));
		delivery1.setStatus(DeliveryStatus.RECEIVED);
		
		Mockito.when(deliveryRepository.save(delivery1)).thenReturn(delivery1);
		assertEquals(delivery1, deliveryService.addDelivery(delivery1));
	}
	
	
	@Test
	void updateDeliveryTest() {
		
		FlatDetails fd1 = new FlatDetails();
		fd1.setFlatNumber(123L);
		fd1.setFloorNumber(6L);
		
		Delivery delivery1 = new Delivery();
		delivery1.setDeliveryId(1L);
		delivery1.setFlatDetails(fd1);
		delivery1.setDeliveryDateTime(LocalDateTime.parse("2021-06-06T12:12:00"));
		delivery1.setStatus(DeliveryStatus.RECEIVED);
		
		Mockito.when(deliveryRepository.getById(1L)).thenReturn(delivery1);
		
		delivery1.setStatus(DeliveryStatus.NOTPICKEDUP);
		Mockito.when(deliveryRepository.save(delivery1)).thenReturn(delivery1);
		
		assertEquals(delivery1, deliveryService.updateDelivery(1L));
	}

}
