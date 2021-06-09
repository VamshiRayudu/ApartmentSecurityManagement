package com.sprint.services;

import java.util.List;

import com.sprint.entities.Delivery;
import com.sprint.entities.DeliveryStatus;

public interface IDeliveryService {
    
     public List<Delivery> getDeliveryList();
    
     public Delivery getDeliveryById(Long id);
     
     public Delivery addDelivery(Delivery delivery);
          
     public Delivery updateDelivery(Delivery delivery);
        
     public Delivery updateDeliveryById(Long id, DeliveryStatus oldStatus, DeliveryStatus newStatus);
         
}
