package com.sprint.services;

import java.util.List;

import com.sprint.entities.Guard;

public interface IGuardService {

	public Guard getGuardById(Long id);
	
	public List<Guard> listAllGuards();
}
