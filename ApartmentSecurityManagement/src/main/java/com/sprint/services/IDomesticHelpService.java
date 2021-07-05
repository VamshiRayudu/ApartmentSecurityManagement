package com.sprint.services;

import java.util.List;

import com.sprint.entities.Attendance;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

/**
 * @author NIJAGNA
 *
 */
public interface IDomesticHelpService {

	/**
	 * @return
	 */
	public List<DomesticHelp> getDomesticHelpList();

	/**
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	public DomesticHelp getDomesticHelpById(Long id) throws UserNotFoundException;

	/**
	 * @param flatNumber
	 * @param domesticHelp
	 * @return
	 */
	public DomesticHelp addDomesticHelp(Long flatNumber, DomesticHelp domesticHelp);

	/**
	 * @param domesticHelp
	 * @return
	 * @throws UserNotFoundException
	 */
	public DomesticHelp updateDomesticHelp(DomesticHelp domesticHelp)throws UserNotFoundException;

	/**
	 * @param id
	 * @param oldHelpType
	 * @param newHelpType
	 * @return
	 * @throws UserNotFoundException
	 */
	public DomesticHelp updateDomesticHelpById(Long id, DomesticHelp domesticHelp) throws UserNotFoundException;

	/**
	 * @param domesticHelpId
	 * @param attendance
	 * @return
	 * @throws UserNotFoundException
	 */
	public DomesticHelp updateAttendance(Long domesticHelpId, Attendance attendance) throws UserNotFoundException;
}
