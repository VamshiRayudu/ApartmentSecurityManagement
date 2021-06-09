package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.FlatDetails;
import com.sprint.entities.Owner;
import com.sprint.repositories.IFlatDetailsRepository;

@Service
@Transactional
public class FlatDetailsServiceImpl implements IFlatDetailsService{

	@Autowired
	private IFlatDetailsRepository flatDetailsRepository;
	
	@Override
	public FlatDetails addFlatDetails(FlatDetails flatDetails) {
		// TODO Auto-generated method stub
		return flatDetailsRepository.saveAndFlush(flatDetails);
	}

	@Override
	public FlatDetails getFlatDetailsById(Long flatNumber)
	{
		// TODO Auto-generated method stub
		return flatDetailsRepository.getById(flatNumber);
	}

	@Override
	public List<FlatDetails> listAllFlatDetails() {
		// TODO Auto-generated method stub
		return flatDetailsRepository.findAll();
	}

	@Override
	public FlatDetails updateFlatDetails(Long flatNumber, Owner ownerDetails) {
		// TODO Auto-generated method stub
		FlatDetails flatDetails=flatDetailsRepository.findById(flatNumber).get();
	
		flatDetails.getOwner().setEmailId(ownerDetails.getEmailId());
		
		flatDetails.getOwner().setPassword(ownerDetails.getPassword());
		
		flatDetails.getOwner().setEmailId(ownerDetails.getEmailId());
		
		flatDetailsRepository.save(flatDetails);
		
		return flatDetails;
	}



}
