package com.sprint;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.entities.Attendance;
import com.sprint.entities.Delivery;
import com.sprint.entities.DeliveryStatus;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;
import com.sprint.entities.FlatDetails;
import com.sprint.entities.Guard;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.repositories.IDeliveryRepository;
import com.sprint.services.DeliveryServiceImpl;

@SpringBootTest
class DeliveryTest {

	@Mock
	IDeliveryRepository deliveryRepository= org.mockito.Mockito.mock(IDeliveryRepository.class);

	@InjectMocks
	DeliveryServiceImpl deliveryService = new DeliveryServiceImpl();


	@Test
	void getDeliveryListTest() {

		FlatDetails flatDetails = new FlatDetails();
		flatDetails.setFlatNumber(123L);
		flatDetails.setFloorNumber(6L);


		List<Delivery> deliveryList = new ArrayList<>();
		Delivery delivery1 = new Delivery(flatDetails, LocalDateTime.parse("2021-06-06T12:12:00"), DeliveryStatus.RECEIVED);
		Delivery delivery2 = new Delivery(flatDetails, LocalDateTime.parse("2021-06-07T12:16:00"), DeliveryStatus.PICKEDUP);

		deliveryList.add(delivery1);
		deliveryList.add(delivery2);

		Mockito.when(deliveryRepository.findAll()).thenReturn(deliveryList);
		assertEquals(deliveryList.size(), deliveryService.getDeliveryList().size());

	}


	@Test
	void getDeliveryByIdTest() throws Exception {

		FlatDetails flatDetails = new FlatDetails();
		flatDetails.setFlatNumber(123L);
		flatDetails.setFloorNumber(6L);

		Delivery delivery = new Delivery(flatDetails, LocalDateTime.parse("2021-05-06T12:12:00"), DeliveryStatus.PICKEDUP);

		Mockito.when(deliveryRepository.save(delivery)).thenReturn(delivery);
		deliveryService.addDelivery(flatDetails.getFlatNumber(),7L,delivery);
		Mockito.when(deliveryRepository.findById(delivery.getDeliveryId())).thenReturn(Optional.of(delivery));

		Delivery d= deliveryService.getDeliveryById(delivery.getDeliveryId());
		assertEquals(d, delivery);

	}


	@Test
	void addDeliveryTest() throws Exception {

		FlatDetails flatDetails = new FlatDetails();
		flatDetails.setFlatNumber(606L);
		flatDetails.setFloorNumber(6L);

		Delivery delivery = new Delivery(flatDetails, LocalDateTime.parse("2021-03-06T12:16:00"), DeliveryStatus.RECEIVED);

		Mockito.when(deliveryRepository.save(delivery)).thenReturn(delivery);
		deliveryService.addDelivery(flatDetails.getFlatNumber(),7L,delivery);
		assertEquals(DeliveryStatus.RECEIVED, delivery.getStatus());

	}


	@Test
	void updateDeliveryTest() throws RecordNotFoundException {

		FlatDetails flatDetails = new FlatDetails();
		flatDetails.setFlatNumber(303L);
		flatDetails.setFloorNumber(3L);

		Delivery delivery = new Delivery(flatDetails, LocalDateTime.parse("2021-05-05T12:13:00"), DeliveryStatus.NOTPICKEDUP);

		delivery.setStatus(DeliveryStatus.PICKEDUP);
		Mockito.when(deliveryRepository.save(delivery)).thenReturn(delivery);
		deliveryService.updateDelivery(delivery);
		assertEquals(DeliveryStatus.PICKEDUP, delivery.getStatus());

	}


	@Test
	void updateDeliveryByIdTest() throws Exception {

		FlatDetails flatDetails = new FlatDetails();
		flatDetails.setFlatNumber(506L);
		flatDetails.setFloorNumber(5L);

		Delivery delivery = new Delivery(flatDetails, LocalDateTime.parse("2021-04-08T12:18:00"), DeliveryStatus.NOTPICKEDUP);

		Mockito.when(deliveryRepository.save(delivery)).thenReturn(delivery);
		deliveryService.addDelivery(flatDetails.getFlatNumber(),7L, delivery);
		Mockito.when(deliveryRepository.findById(delivery.getDeliveryId())).thenReturn(Optional.of(delivery));

		delivery.setStatus( DeliveryStatus.PICKEDUP);
		Mockito.when(deliveryRepository.save(delivery)).thenReturn(delivery);

		assertThat(deliveryService.updateDeliveryById(delivery.getDeliveryId(), DeliveryStatus.PICKEDUP, DeliveryStatus.NOTPICKEDUP)).isEqualTo(delivery);


	}

}