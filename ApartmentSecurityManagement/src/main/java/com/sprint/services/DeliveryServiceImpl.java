package com.sprint.services;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Delivery;
import com.sprint.entities.DeliveryStatus;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;
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
	public Delivery getDeliveryById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<Delivery> delivery = deliveryRepository.findById(id);
		if(delivery != null)
		{
			return delivery.get();
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found");
		}
	}

	@Override
	public Delivery addDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
			return deliveryRepository.save(delivery);
	}

	@Override
	public Delivery updateDelivery(Delivery delivery) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<Delivery> delivery1 = deliveryRepository.findById(delivery.getDeliveryId());
		if(delivery1 != null)
		{
			return deliveryRepository.save(delivery);
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found");
		}
	}

	@Override
	public Delivery updateDeliveryById(Long id, DeliveryStatus oldStatus, DeliveryStatus newStatus) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<Delivery> delivery = deliveryRepository.findById(id);
		
		if(delivery != null)
		{
			if(delivery.get().getStatus() == oldStatus)
			{
				delivery.get().setStatus(newStatus);
				return deliveryRepository.save(delivery.get());
			}
			else
			{
				throw new ValidationException("Incorrect Status");
			}
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found");
		}
	}
}