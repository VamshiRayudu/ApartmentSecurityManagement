package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Owner;
import com.sprint.repositories.IOwnerRepository;

@Service
@Transactional
public class OwnerServiceImpl implements IOwnerService{

	@Autowired
	private IOwnerRepository ownerRepository;

	@Override
	public Owner addOwner(Owner owner) {
		// TODO Auto-generated method stub
		return ownerRepository.saveAndFlush(owner);
	}

	@Override
	public Owner getOwnerById(Long id) {
		// TODO Auto-generated method stub
		return ownerRepository.getById(id);
	}

	@Override
	public List<Owner> getAllOwnerList() {
		// TODO Auto-generated method stub
		return ownerRepository.findAll();
	}

	@Override
	public Owner updateOwner(Owner owner) {
		// TODO Auto-generated method stub
		return ownerRepository.saveAndFlush(owner);
	}

	@Override
	public Owner updateOwnerById(Long id,String oldName,String newName) {
		// TODO Auto-generated method stub
		Owner owner = ownerRepository.findById(id).get();
		if(owner.getPassword()==oldName)
		{
			owner.setPassword(newName);
			ownerRepository.saveAndFlush(owner);
		}
		return owner;
	}

	@Override
	public Owner deleteOwnerById(Long id) {
		// TODO Auto-generated method stub
		//first I am retrieving from the repository the owner  by that Id
		Owner owner = ownerRepository.findById(id).get();

		//performing a delete operation  on this id 
		ownerRepository.deleteById(id);

		//returning owner which is deleted
		return owner;



	}

	@Override
	public Owner deleteOwner(Owner owner) {
		// TODO Auto-generated method stub
		return ownerRepository.saveAndFlush(owner);
	}





}
