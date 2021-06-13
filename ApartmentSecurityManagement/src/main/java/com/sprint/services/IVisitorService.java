package com.sprint.services;

import java.util.List;

import com.sprint.entities.Visitor;
import com.sprint.exceptions.RecordNotFoundException;

/**
 * @author VISHNU KUMAR
 *
 */
public interface IVisitorService {
	
	/**
	 * @return
	 */
	public List<Visitor> getVisitorList();
	
	/**
	 * @param visitor
	 * @param guardId
	 * @return
	 */
	public Visitor addVisitor(Visitor visitor, Long guardId);
	
	/**
	 * @param visitor
	 * @param guardId
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Visitor updateVisitor (Visitor visitor, Long guardId) throws RecordNotFoundException;

	/**
	 * @param Id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Visitor getVisitorById(Long Id) throws RecordNotFoundException;
	
	/**
	 * @param Id
	 * @param visitorname
	 * @param mobilenumber
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Visitor updateVisitorById(Long Id,String visitorname,String mobilenumber) throws RecordNotFoundException;
	
	/**
	 * @param visitor
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Visitor deleteVisitor(Visitor visitor) throws RecordNotFoundException;
	
	/**
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Visitor deleteVisitorById(Long id) throws RecordNotFoundException;
	
}
