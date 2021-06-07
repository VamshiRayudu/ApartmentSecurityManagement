package com.sprint.services;

import java.util.List;

import com.sprint.entities.Owner;

public interface IOwnerService {

	public Owner getOwnerById(Long id);
	
	public Owner getOwnerByFlatNo(Long flatNumber);
}
