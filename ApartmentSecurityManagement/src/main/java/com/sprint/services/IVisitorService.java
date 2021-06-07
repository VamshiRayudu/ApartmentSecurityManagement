package com.sprint.services;

import com.sprint.entities.Visitor;

public interface IVisitorService {
	
	public Visitor addVisitor(Visitor visitor);
	
	
	
	public Visitor getVisitorById(Long id);
	
	public Visitor updateVisitorById(Long id);
	
	public Visitor deleteVisitorById(Long id);

}
