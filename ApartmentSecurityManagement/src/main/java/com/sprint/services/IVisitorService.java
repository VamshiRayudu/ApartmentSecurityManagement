package com.sprint.services;

import java.util.List;

import com.sprint.entities.Visitor;

public interface IVisitorService {
	
	public List<Visitor> getVisitorList();
	
	public Visitor addVisitor(Visitor visitor);
	
	public Visitor updateVisitor (Visitor visitor);

	public Visitor getVisitorById(Long Id);
	
	public Visitor updateVisitorById(Long Id);
	
	public Visitor deleteVisitor(Visitor visitor);
	
	public Visitor deleteVisitorById(Long id);
	
}
