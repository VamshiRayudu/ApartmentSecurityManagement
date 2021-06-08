package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.entities.FlatDetails;

@Service
@Transactional
public class FlatDetailsServiceImpl implements IFlatDetailsService{

	@Override
	public FlatDetails addFlatDetails(FlatDetails flatDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlatDetails getFlatDetailsById(Long flatNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatDetails> listAllFlatDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlatDetails updateFlatDetails(Long flatNumber) {
		// TODO Auto-generated method stub
		return null;
	}



}
