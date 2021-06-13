package com.sprint.services;

import java.util.List;

import com.sprint.entities.Delivery;
import com.sprint.entities.DeliveryStatus;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;

/**
 * @author NIJAGNA
 *
 */
public interface IDeliveryService {
    
    /**
     * @return
     */
    public List<Delivery> getDeliveryList();
    
    /**
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    public Delivery getDeliveryById(Long id) throws RecordNotFoundException;
    
    /**
     * @param flatId
     * @param guardId
     * @param delivery
     * @return
     * @throws Exception
     */
    public Delivery addDelivery(Long flatId, Long guardId, Delivery delivery) throws Exception;
         
    /**
     * @param delivery
     * @return
     * @throws RecordNotFoundException
     */
    public Delivery updateDelivery(Delivery delivery) throws RecordNotFoundException;
       
    /**
     * @param id
     * @param oldStatus
     * @param newStatus
     * @return
     * @throws RecordNotFoundException
     */
    public Delivery updateDeliveryById(Long id, DeliveryStatus oldStatus, DeliveryStatus newStatus) throws RecordNotFoundException;
         
}
