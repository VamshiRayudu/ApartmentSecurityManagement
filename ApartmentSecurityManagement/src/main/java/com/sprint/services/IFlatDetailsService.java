package com.sprint.services;

import java.util.List;

import com.sprint.entities.FlatDetails;
import com.sprint.entities.Owner;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;

public interface IFlatDetailsService {
	
	public FlatDetails addFlatDetails(FlatDetails flatDetails);
	
	public FlatDetails getFlatDetailsById(Long flatNumber) throws RecordNotFoundException;
	
	public List<FlatDetails> listAllFlatDetails();
	
	public FlatDetails updateFlatDetails(Long flatNumber, Owner ownerDetails) throws RecordNotFoundException;

}
