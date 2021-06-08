package com.sprint.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;
import com.sprint.repositories.IDomesticHelpRepository;

@Service
@Transactional
public class DomesticHelpService implements IDomesticHelpService {

	@Autowired
	private IDomesticHelpRepository domesticHelpRepository;
	
	@Override
	public List<DomesticHelp> getDomesticHelpList() {
		// TODO Auto-generated method stub
		return domesticHelpRepository.findAll();
	}

	@Override
	public DomesticHelp getDomesticHelpById(Long id) {
		// TODO Auto-generated method stub
		return domesticHelpRepository.getById(id);
	}

	@Override
	public DomesticHelp addDomesticHelp(DomesticHelp domesticHelp) {
		// TODO Auto-generated method stub
		return domesticHelpRepository.saveAndFlush(domesticHelp);
	}

	@Override
	public DomesticHelp updateDomesticHelpById(Long id , DomesticHelpType oldHelpType , DomesticHelpType newHelpType) {
		// TODO Auto-generated method stub
		DomesticHelp domesticHelp = domesticHelpRepository.findById(id).get();
		
		if(domesticHelp.getHelpType() == oldHelpType)
		{
			domesticHelp.setHelpType(newHelpType);
			domesticHelpRepository.saveAndFlush(domesticHelp);
		}
		else
		{
			//throw Exception
		}
		return domesticHelp;
	}

	@Override
	public DomesticHelp updateDomesticHelp(DomesticHelp domesticHelp) {
		// TODO Auto-generated method stub
		return domesticHelpRepository.saveAndFlush(domesticHelp);
	}

}