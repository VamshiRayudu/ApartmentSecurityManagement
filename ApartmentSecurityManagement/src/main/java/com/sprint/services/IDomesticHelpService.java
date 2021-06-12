package com.sprint.services;

import java.util.List;

import com.sprint.entities.Attendance;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

public interface IDomesticHelpService {

	public List<DomesticHelp> getDomesticHelpList();

	public DomesticHelp getDomesticHelpById(Long id) throws UserNotFoundException;

	public DomesticHelp addDomesticHelp(Long flatNumber, DomesticHelp domesticHelp);

	public DomesticHelp updateDomesticHelp(DomesticHelp domesticHelp)throws UserNotFoundException;

	public DomesticHelp updateDomesticHelpById(Long id, DomesticHelpType oldHelpType , DomesticHelpType newHelpType) throws UserNotFoundException;

	public DomesticHelp updateAttendance(Long domesticHelpId, Attendance attendance) throws UserNotFoundException;
}
