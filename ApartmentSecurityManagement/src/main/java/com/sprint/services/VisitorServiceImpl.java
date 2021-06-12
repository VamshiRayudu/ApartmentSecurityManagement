package com.sprint.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Visitor;
import com.sprint.exceptions.RecordNotFoundException;
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
	public Visitor updateVisitor(Visitor visitor)throws RecordNotFoundException {
		Optional<Visitor> user = visitorRepository.findById(visitor.getId());
		// TODO Auto-generated method stub
		if(user!=null)
		{
			return visitorRepository.save(visitor);
		}
		else
		{
			throw new RecordNotFoundException("Record not found");
		}
	}

	@Override
	public Visitor getVisitorById(Long Id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<Visitor> visitor=visitorRepository.findById(Id);
		if(visitor!=null)
		{
			return visitorRepository.getById(Id);
		}
		else
		{
			throw new RecordNotFoundException("user not found");
		}
	}
	@Override
	public Visitor updateVisitorById(Long Id,String visitorName,String mobileNumber)throws RecordNotFoundException {
		Optional<Visitor>visitor=visitorRepository.findById(Id);
		if(visitor!=null)
		{
			visitor.get().setVisitorName(visitorName);
			visitor.get().setMobileNumber(mobileNumber);
			return visitorRepository.save(visitor.get());
		}
		else
		{
			throw new  RecordNotFoundException("Record not found");
		}
	}

	@Override
	public Visitor deleteVisitor(Visitor visitor) throws RecordNotFoundException{
		Optional<Visitor> visitorDelete=visitorRepository.findById(visitor.getId());
		if(visitorDelete.get()!=null)
		{
			visitorRepository.delete(visitor);
		}
		else
		{
			throw new RecordNotFoundException("user not found");
		}
		return visitor;
	}

	@Override
	public Visitor deleteVisitorById(Long id)throws RecordNotFoundException {
		Optional<Visitor> deleteVisitor=visitorRepository.findById(id);
		if(deleteVisitor !=null)
		{
			visitorRepository.deleteById(id);
		}
		else
		{
			throw new RecordNotFoundException("user not found");
		}

		return deleteVisitor.get();
	}
}
