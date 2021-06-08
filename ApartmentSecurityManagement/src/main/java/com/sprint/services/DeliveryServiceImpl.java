package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.entities.Delivery;

@Service
@Transactional
public class DeliveryServiceImpl implements IDeliveryService{

	@Override
	public List<Delivery> getDeliveryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Delivery getDelivery(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Delivery addDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Delivery updateDelivery(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Delivery updateDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		return null;
	}

}
