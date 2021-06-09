package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Visitor;
import com.sprint.repositories.IVisitorRepository;

@Service
@Transactional
public class VisitorServiceImpl implements IVisitorService{

	@Autowired
	private IVisitorRepository visitorRepository;
	
	@Override
	public Visitor addVisitor(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitorRepository.save(visitor);
	}

	@Override
	public List<Visitor> getVisitorList() {
		// TODO Auto-generated method stub
		return visitorRepository.findAll();
	}

	@Override
	public Visitor updateVisitor(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitorRepository.saveAndFlush(visitor);
	}

	@Override
	public Visitor getVisitorById(Long Id) {
		// TODO Auto-generated method stub
		return  visitorRepository.getById(Id) ;
	}

	@Override
	public Visitor updateVisitorById(Long Id,String visitorname,String mobilenumber) {
		// TODO Auto-generated method stub
		Visitor visitor=visitorRepository.findById(Id).get();
		visitor.setVisitorName(visitorname);
		visitor.setMobileNumber(mobilenumber);
		
		return visitorRepository.saveAndFlush(visitor);
		
	}

	@Override
	public Visitor deleteVisitor(Visitor visitor) {
		// TODO Auto-generated method stub
		Visitor visitorDb = visitorRepository.findById(visitor.getId()).get();
		
		
		visitorRepository.delete(visitor);
		
		
		return visitorDb;

	}

	@Override
	public Visitor deleteVisitorById(Long id) {
		// TODO Auto-generated method stub

		Visitor visitor= visitorRepository .findById(id).get();
			visitorRepository.deleteById(id);
		
	
		return visitor;

		
	}

}
