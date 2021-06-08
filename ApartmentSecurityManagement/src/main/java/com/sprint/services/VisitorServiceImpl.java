package com.sprint.services;

import java.util.List;

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

	@Override
	public List<Visitor> getVisitorList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visitor updateVisitor(Visitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visitor getVisitorById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visitor updateVisitorById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visitor deleteVisitor(Visitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visitor deleteVisitorById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
