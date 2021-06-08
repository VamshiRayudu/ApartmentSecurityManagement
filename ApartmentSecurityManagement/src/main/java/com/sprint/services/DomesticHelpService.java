package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.entities.DomesticHelp;

@Service
@Transactional
public class DomesticHelpService implements IDomesticHelpService {

	@Override
	public List<DomesticHelp> getDomesticHelpList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomesticHelp getDomesticHelpById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomesticHelp addDomesticHelp(DomesticHelp domesticHelp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomesticHelp updateDomesticHelpById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomesticHelp updateDomesticHelp(DomesticHelp domesticHelp) {
		// TODO Auto-generated method stub
		return null;
	}

}
