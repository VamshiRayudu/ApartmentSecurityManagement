package com.sprint.services;

import java.util.List;

import com.sprint.entities.Delivery;

public interface IDeliveryService {
    
     public List<Delivery> getDeliveryList();
    
     public Delivery getDelivery(Long id);
     
     public Delivery addDelivery(Delivery delivery);
          
     public Delivery updateDelivery(Delivery delivery);
        
     public Delivery updateDelivery(Long id); 
         
}
