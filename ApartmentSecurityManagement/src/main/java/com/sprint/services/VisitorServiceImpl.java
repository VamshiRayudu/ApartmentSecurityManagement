package com.sprint.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprint.entities.Visitor;
import com.sprint.repositories.IVisitorRepository;

public class VisitorServiceImpl implements IVisitorService{

	@Autowired
	private IVisitorRepository visitorRepository;
	
	@Override
	public Visitor addVisitor(Visitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
