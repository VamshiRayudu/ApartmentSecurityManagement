package com.sprint.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Delivery;
import com.sprint.entities.DeliveryStatus;
import com.sprint.repositories.IDeliveryRepository;

@Service
@Transactional
public class DeliveryServiceImpl implements IDeliveryService{

	@Autowired
	private IDeliveryRepository deliveryRepository;

	@Override
	public List<Delivery> getDeliveryList() {
		// TODO Auto-generated method stub
		return deliveryRepository.findAll();
	}

	@Override
	public Delivery getDeliveryById(Long id) {
		// TODO Auto-generated method stub
		return deliveryRepository.getById(id);
	}

	@Override
	public Delivery addDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		return deliveryRepository.saveAndFlush(delivery);
	}

	@Override
	public Delivery updateDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		return deliveryRepository.saveAndFlush(delivery);
	}

	@Override
	public Delivery updateDeliveryById(Long id, DeliveryStatus oldStatus, DeliveryStatus newStatus) {
		// TODO Auto-generated method stub
		Delivery delivery = deliveryRepository.findById(id).get();
		
		if(delivery.getStatus() == oldStatus)
		{
			delivery.setStatus(newStatus);
			deliveryRepository.saveAndFlush(delivery);
		}
		else
		{
			//throw Exception
		}
		
		return delivery;

	}
	
	
}