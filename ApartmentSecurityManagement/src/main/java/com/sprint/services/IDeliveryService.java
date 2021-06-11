package com.sprint.services;

import java.util.List;

import com.sprint.entities.Delivery;
import com.sprint.entities.DeliveryStatus;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;

public interface IDeliveryService {
    
    public List<Delivery> getDeliveryList();
    
    public Delivery getDeliveryById(Long id) throws RecordNotFoundException;
    
    public Delivery addDelivery(Long flatId, Long guardId, Delivery delivery) throws Exception;
         
    public Delivery updateDelivery(Delivery delivery) throws RecordNotFoundException;
       
    public Delivery updateDeliveryById(Long id, DeliveryStatus oldStatus, DeliveryStatus newStatus) throws RecordNotFoundException;
         
}
