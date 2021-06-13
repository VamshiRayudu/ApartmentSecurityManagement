package com.sprint.services;

import java.util.List;

import com.sprint.entities.FlatDetails;
import com.sprint.entities.Owner;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;

/**
 * @author KUNDANA PRIYA
 *
 */
public interface IFlatDetailsService {
	
	/**
	 * @param flatDetails
	 * @return
	 */
	public FlatDetails addFlatDetails(FlatDetails flatDetails);
	
	/**
	 * @param flatNumber
	 * @return
	 * @throws RecordNotFoundException
	 */
	public FlatDetails getFlatDetailsById(Long flatNumber) throws RecordNotFoundException;
	
	/**
	 * @return
	 */
	public List<FlatDetails> listAllFlatDetails();
	
	/**
	 * @param flatNumber
	 * @param ownerDetails
	 * @return
	 * @throws RecordNotFoundException
	 */
	public FlatDetails updateFlatDetails(Long flatNumber, Owner ownerDetails) throws RecordNotFoundException;

}
