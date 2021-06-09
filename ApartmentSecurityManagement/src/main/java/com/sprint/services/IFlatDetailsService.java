package com.sprint.services;

import java.util.List;

import com.sprint.entities.FlatDetails;
import com.sprint.entities.Owner;

public interface IFlatDetailsService {
	
	public FlatDetails addFlatDetails(FlatDetails flatDetails);
	
	public FlatDetails getFlatDetailsById(Long flatNumber);
	
	public List<FlatDetails> listAllFlatDetails();
	
	public FlatDetails updateFlatDetails(Long flatNumber, Owner ownerDetails);
	
	
}
