package com.sprint.services;

import java.util.List;

import com.sprint.entities.Visitor;
import com.sprint.exceptions.RecordNotFoundException;

public interface IVisitorService {
	
	public List<Visitor> getVisitorList();
	
	public Visitor addVisitor(Visitor visitor, Long guardId);
	
	public Visitor updateVisitor (Visitor visitor, Long guardId) throws RecordNotFoundException;

	public Visitor getVisitorById(Long Id) throws RecordNotFoundException;
	
	public Visitor updateVisitorById(Long Id,String visitorname,String mobilenumber) throws RecordNotFoundException;
	
	public Visitor deleteVisitor(Visitor visitor) throws RecordNotFoundException;
	
	public Visitor deleteVisitorById(Long id) throws RecordNotFoundException;
	
}
