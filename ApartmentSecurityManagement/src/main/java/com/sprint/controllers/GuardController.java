package com.sprint.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entities.Admin;
import com.sprint.entities.Attendance;
import com.sprint.entities.Delivery;
import com.sprint.entities.DeliveryStatus;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;
import com.sprint.entities.Guard;
import com.sprint.entities.GuardSalary;
import com.sprint.entities.GuardShift;
import com.sprint.entities.Owner;
import com.sprint.entities.SecurityAlert;
import com.sprint.entities.Vehicle;
import com.sprint.entities.VehicleUpdates;
import com.sprint.entities.Visitor;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IGuardRepository;
import com.sprint.repositories.IVehicleRepository;
import com.sprint.services.IDeliveryService;
import com.sprint.services.IDomesticHelpService;
import com.sprint.services.IGuardService;
import com.sprint.services.ISecurityAlertService;
import com.sprint.services.IVehicleService;
import com.sprint.services.IVisitorService;

/**
 * @authors SHUBHAM ,VISHNU KUMAR
 *
 */
@RestController
@RequestMapping("api/v1/")
public class GuardController {

	static final Logger LOGGER = LoggerFactory.getLogger(GuardController.class);

	@Autowired
	private IGuardService guardService;

	@Autowired
	private IVisitorService visitorService;

	@Autowired
	private ISecurityAlertService securityAlertService;

	@Autowired
	private IDeliveryService deliveryService;

	@Autowired
	private IDomesticHelpService domesticHelpService;

	@Autowired
	private IVehicleService vehicleService;

	@Autowired
	private IVehicleRepository vehicleRepository;
	
	@Autowired
	private IGuardRepository guardRepository;

	/**
	 * @param id
	 * @param attendance
	 * @return ResponseEntity<Guard>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PutMapping("guard/{id}/Attendance")
	public ResponseEntity<Guard> updateGuardAttendance(@Valid @PathVariable Long id, @RequestBody Attendance attendance)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateGuardAttendance URL is opened");
		LOGGER.info("updateGuardAttendance() is initiated");
		return new ResponseEntity<Guard>(guardService.updateGuardAttendance(id, attendance), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return ResponseEntity<Guard>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("guard/Id")
	public ResponseEntity<Guard> updateGuardById(@Valid @PathVariable Long id, @RequestParam String oldPassword,
			@RequestParam String newPassword) throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateGuardById URL is opened");
		LOGGER.info("updateGuardById() is initiated");
		return new ResponseEntity<Guard>(guardService.updateGuardById(id, oldPassword, newPassword), HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<SecurityAlert>>
	 */
	@GetMapping("guard/securityAlert")
	public ResponseEntity<List<SecurityAlert>> getAllSecurityAlert() {
		LOGGER.info("getAllSecurityAlert URL is opened");
		LOGGER.info("getAllSecurityAlert() is initiated");
		return new ResponseEntity<List<SecurityAlert>>(securityAlertService.getSecurityAlertList(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<SecurityAlert>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/securityAlert/getSecurityAlertById")
	public ResponseEntity<SecurityAlert> getSecurityAlertById(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getSecurityAlertById URL is opened");
		LOGGER.info("getSecurityAlertById() is initiated");
		return new ResponseEntity<SecurityAlert>(securityAlertService.getSecurityAlertById(id), HttpStatus.OK);
	}

	/**
	 * @param securityAlert
	 * @return ResponseEntity<SecurityAlert>
	 * @throws DuplicateRecordException
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("guard/securityAlert")
	public ResponseEntity<SecurityAlert> addSecurityAlert(@Valid @RequestBody SecurityAlert securityAlert)
			throws DuplicateRecordException, MethodArgumentNotValidException {
		LOGGER.info("addSecurityAlert URL is opened");
		LOGGER.info("addSecurityAlert() is initiated");
		return new ResponseEntity<SecurityAlert>(securityAlertService.addSecurityAlert(securityAlert),
				HttpStatus.CREATED);
	}

	/**
	 * @param id
	 * @param oldMessage
	 * @param newMessage
	 * @return ResponseEntity<SecurityAlert>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("guard/securityAlert/{id}")
	public ResponseEntity<SecurityAlert> updateSecurityAlertMessage(@Valid @PathVariable Long id,
			@RequestParam String oldMessage, @RequestParam String newMessage)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateSecurityAlertMessage URL is opened");
		LOGGER.info("updateSecurityAlertMessage() is initiated");
		return new ResponseEntity<SecurityAlert>(
				securityAlertService.updateSecurityAlertById(id, oldMessage, newMessage), HttpStatus.OK);
	}

	/**
	 * @param securityAlert
	 * @return ResponseEntity<SecurityAlert>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PutMapping("guard/securityAlert")
	public ResponseEntity<SecurityAlert> updateSecurityAlert(@Valid @RequestBody SecurityAlert securityAlert)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateSecurityAlert URL is opened");
		LOGGER.info("updateSecurityAlert() is initiated");
		return new ResponseEntity<SecurityAlert>(securityAlertService.updateSecurityAlert(securityAlert),
				HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return ResponseEntity<List<SecurityAlert>>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/getSecurityAlertsByGuardId")
	public ResponseEntity<List<SecurityAlert>> getSecurityAlertsByAdminId(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getAdminById URL is opened");
		LOGGER.info("getAdminById() is initiated");
		Guard guard = guardService.getGuardById(id);
		return new ResponseEntity<List<SecurityAlert>>(guard.getSecurityAlerts(), HttpStatus.OK);
	}


	/**
	 * @return ResponseEntity<List<Delivery>>
	 */
	@GetMapping("guard/delivery")
	public ResponseEntity<List<Delivery>> getAllDeliveries() {
		LOGGER.info("getAllDeliveries URL is opened");
		LOGGER.info("getAllDeliveries() is initiated");
		return new ResponseEntity<List<Delivery>>(deliveryService.getDeliveryList(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Delivery>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/delivery/getDeliveryById")
	public ResponseEntity<Delivery> getDeliveryById(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getDeliveryById URL is opened");
		LOGGER.info("getDeliveryById() is initiated");
		return new ResponseEntity<Delivery>(deliveryService.getDeliveryById(id), HttpStatus.OK);
	}

	/**
	 * @param flatId
	 * @param guardId
	 * @param delivery
	 * @return ResponseEntity<Delivery>
	 * @throws Exception
	 */
	@PostMapping("guard/delivery/addDelivery")
	public ResponseEntity<Delivery> addDelivery(@Valid @RequestParam Long flatId, @RequestParam Long guardId,
			@RequestBody Delivery delivery) throws Exception {
		LOGGER.info("addDelivery URL is opened");
		LOGGER.info("addDelivery() is initiated");
		return new ResponseEntity<Delivery>(deliveryService.addDelivery(flatId, guardId, delivery), HttpStatus.CREATED);
	}

	/**
	 * @param delivery
	 * @return ResponseEntity<Delivery>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PutMapping("guard/delivery")
	public ResponseEntity<Delivery> updateDelivery(@Valid @RequestBody Delivery delivery)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateDelivery URL is opened");
		LOGGER.info("updateDelivery() is initiated");
		return new ResponseEntity<Delivery>(deliveryService.updateDelivery(delivery), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param oldStatus
	 * @param newStatus
	 * @return ResponseEntity<Delivery>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("guard/delivery/{id}")
	public ResponseEntity<Delivery> updateDeliveryStatusById(@Valid @PathVariable Long id,
			@RequestParam DeliveryStatus oldStatus, @RequestParam DeliveryStatus newStatus)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateDeliveryStatusById URL is opened");
		LOGGER.info("updateDeliveryStatusById() is initiated");
		return new ResponseEntity<Delivery>(deliveryService.updateDeliveryById(id, oldStatus, newStatus),
				HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<DomesticHelp>>
	 */
	@GetMapping("guard/domesticHelps")
	public ResponseEntity<List<DomesticHelp>> getDomesticHelpList() {

		LOGGER.info("getDomesticHelpList URL is opened");
		LOGGER.info("getDomesticHelpList() is initiated");
		return new ResponseEntity<List<DomesticHelp>>(domesticHelpService.getDomesticHelpList(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<DomesticHelp>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/domesticHelps/getDomesticHelpById")
	public ResponseEntity<DomesticHelp> getDomesticHelpById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getDomesticHelpById URL is opened");
		LOGGER.info("getDomesticHelpById() is initiated");
		return new ResponseEntity<DomesticHelp>(domesticHelpService.getDomesticHelpById(id), HttpStatus.OK);
	}

	/**
	 * @param domesticHelp
	 * @param flatNumber
	 * @return ResponseEntity<DomesticHelp>
	 * @throws DuplicateRecordException
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("guard/domesticHelps")
	public ResponseEntity<DomesticHelp> addDomesticHelp(@Valid @RequestBody DomesticHelp domesticHelp,
			@RequestParam Long flatNumber) throws DuplicateRecordException, MethodArgumentNotValidException {

		LOGGER.info("addDomesticHelp URL is opened");
		LOGGER.info("addDomesticHelp() is initiated");
		return new ResponseEntity<DomesticHelp>(domesticHelpService.addDomesticHelp(flatNumber, domesticHelp),
				HttpStatus.CREATED);
	}

	/**
	 * @param domsticHelp
	 * @return ResponseEntity<DomesticHelp>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PutMapping("guard/updateDomesticHelp")
	public ResponseEntity<DomesticHelp> updateDomesticHelp(@Valid @RequestBody DomesticHelp domsticHelp)
			throws UserNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("updateDomesticHelp URL is opened");
		LOGGER.info("updateDomesticHelp() is initiated");
		return new ResponseEntity<DomesticHelp>(domesticHelpService.updateDomesticHelp(domsticHelp), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param oldHelpType
	 * @param newHelpType
	 * @return ResponseEntity<DomesticHelp>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("guard/domesticHelps/{id}")
	public ResponseEntity<DomesticHelp> updateDomesticHelpById(@Valid @PathVariable("id") Long id,
			@RequestParam DomesticHelpType oldHelpType, @RequestParam DomesticHelpType newHelpType)
			throws UserNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("updateDomesticHelpById URL is opened");
		LOGGER.info("updateDomesticHelpById() is initiated");
		return new ResponseEntity<DomesticHelp>(
				domesticHelpService.updateDomesticHelpById(id, oldHelpType, newHelpType), HttpStatus.OK);
	}

	/**
	 * @param domesticHelpId
	 * @param attendance
	 * @return ResponseEntity<DomesticHelp>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("guard/domesticHelp/Attendance")
	public ResponseEntity<DomesticHelp> updateAttendance(@Valid @RequestParam Long domesticHelpId,
			@RequestBody Attendance attendance) throws UserNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("updateAttendance URL is opened");
		LOGGER.info("updateAttendance() is initiated");
		return new ResponseEntity<DomesticHelp>(domesticHelpService.updateAttendance(domesticHelpId, attendance),
				HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<Visitor>>
	 */
	@GetMapping("guard/visitor")
	public ResponseEntity<List<Visitor>> getVisitorList() {
		LOGGER.info("getVisitorList URL is opened");
		LOGGER.info("getVisitorList() is initiated");
		return new ResponseEntity<List<Visitor>>(visitorService.getVisitorList(), HttpStatus.OK);
	}

	/**
	 * @param visitor
	 * @param guardId
	 * @return ResponseEntity<Visitor>
	 */
	@PostMapping("guard/visitor")
	public ResponseEntity<Visitor> addVisitor(@Valid @RequestBody Visitor visitor, @RequestParam Long guardId) {
		LOGGER.info("addVisitor URL is opened");
		LOGGER.info("addVisitor() is initiated");
		return new ResponseEntity<Visitor>(visitorService.addVisitor(visitor, guardId), HttpStatus.CREATED);
	}

	/**
	 * @param visitor
	 * @param guardId
	 * @return ResponseEntity<Visitor>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PutMapping("guard/visitor")
	public ResponseEntity<Visitor> updateVisitor(@Valid @RequestBody Visitor visitor, @RequestParam Long guardId)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateVisitor URL is opened");
		LOGGER.info("updateVisitor() is initiated");
		return new ResponseEntity<Visitor>(visitorService.updateVisitor(visitor, guardId), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Visitor>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/visitor/getVisitorById")
	public ResponseEntity<Visitor> getvisitorById(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getvisitorById URL is opened");
		LOGGER.info("getvisitorById() is initiated");
		return new ResponseEntity<Visitor>(visitorService.getVisitorById(id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param visitorname
	 * @param mobilenumber
	 * @return ResponseEntity<Visitor>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("guard/visitor/{id}")
	public ResponseEntity<Visitor> updateVisitorById(@Valid @PathVariable Long id, @RequestParam String visitorname,
			String mobilenumber) throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateVisitorById URL is opened");
		LOGGER.info("updateVisitorById() is initiated");
		return new ResponseEntity<Visitor>(visitorService.updateVisitorById(id, visitorname, mobilenumber),
				HttpStatus.OK);
	}

	/**
	 * @param visitor
	 * @return ResponseEntity<Visitor>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("guard/visitor")
	public ResponseEntity<Visitor> deleteVisitor(@Valid @RequestBody Visitor visitor)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("deleteVisitor URL is opened");
		LOGGER.info("deleteVisitor() is initiated");
		return new ResponseEntity<Visitor>(visitorService.deleteVisitor(visitor), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Visitor>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("guard/visitor/{id}")
	public ResponseEntity<Visitor> deleteVisitorById(@Valid @PathVariable Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("deleteVisitorById URL is opened");
		LOGGER.info("deleteVisitorById() is initiated");
		return new ResponseEntity<Visitor>(visitorService.deleteVisitorById(id), HttpStatus.OK);
	}

	/**
	 * @param guard
	 * @return ResponseEntity<Guard>
	 * @throws UserNotFoundException 
	 */
	@PostMapping("guard/login")
	public ResponseEntity<Guard> LoginGuard(@RequestBody Guard guard) throws UserNotFoundException {
		LOGGER.info("LoginGuard URL is opened");
		LOGGER.info("LoginGuard() is initiated");
		Optional<Guard> user = guardRepository.findById(guard.getId());
		if (user.get().getEmailId() != null) {
			if(user.get().getPassword().equals(guard.getPassword()))
			{
				return new ResponseEntity<Guard>(user.get(), HttpStatus.OK);
			}
			else
			{
				throw new ValidationException("Invalid Password");
			}
		} else {
			throw new UserNotFoundException("No Account Found");
		}
	}

	/**
	 * @param vehicleId
	 * @param vUpdate
	 * @return ResponseEntity<Vehicle>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("guard/vehicleUpdates")
	public ResponseEntity<Vehicle> updateVehicleUpdate(@Valid @RequestParam Long vehicleId,
			@RequestBody VehicleUpdates vUpdate) throws RecordNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("updateVehicleUpdate URL is opened");
		LOGGER.info("updateVehicleUpdate() is initiated");
		return new ResponseEntity<Vehicle>(vehicleService.updateVehicleUpdate(vehicleId, vUpdate), HttpStatus.OK);
	}

	/**
	 * @param numberPlate
	 * @return ResponseEntity<Vehicle>
	 */
	@GetMapping("guard/vehicleUpdates/getByVehicleNumber")
	public ResponseEntity<Vehicle> findByNumberPlate(@Valid @RequestParam String numberPlate) {

		LOGGER.info("findByNumberPlate URL is opened");
		LOGGER.info("findByNumberPlate() is initiated");
		return new ResponseEntity<Vehicle>(vehicleRepository.findByNumberPlate(numberPlate), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Vehicle>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/vehicles/getVehicleById")
	public ResponseEntity<Vehicle> getVehiclesById(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getVehiclesById URL is opened");
		LOGGER.info("getVehiclesById() is initiated");
		return new ResponseEntity<Vehicle>(vehicleService.getVehiclesById(id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<List<Attendance>>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/getGuardAttendanceById")
	public ResponseEntity<List<Attendance>> getGuardAttendanceById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getGuardById URL is opened");
		LOGGER.info("getGuardById() is initiated");
		Guard guard = guardService.getGuardById(id);
		return new ResponseEntity<List<Attendance>>(guard.getGuardAttendances(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<List<GuardSalary>>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/getGuardSalariesById")
	public ResponseEntity<List<GuardSalary>> getGuardSalariesById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getGuardById URL is opened");
		LOGGER.info("getGuardById() is initiated");
		Guard guard = guardService.getGuardById(id);
		return new ResponseEntity<List<GuardSalary>>(guard.getGuardSalaries(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<GuardShift>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/getGuardShiftsById")
	public ResponseEntity<GuardShift> getGuardShiftsById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getGuardById URL is opened");
		LOGGER.info("getGuardById() is initiated");
		Guard guard = guardService.getGuardById(id);

		return new ResponseEntity<GuardShift>(guard.getGuardShifts(), HttpStatus.OK);
	}
	
	/**
	 * @return ResponseEntity<List<Vehicle>>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("guard/vehicles/getAllVehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles()
			throws RecordNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getVehiclesById URL is opened");
		LOGGER.info("getVehiclesById() is initiated");
		return new ResponseEntity<List<Vehicle>>(vehicleService.getAllVehicles(), HttpStatus.OK);
	}
}