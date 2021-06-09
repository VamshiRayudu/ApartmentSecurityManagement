package com.sprint.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.sprint.entities.Attendance;
import com.sprint.entities.Delivery;
import com.sprint.entities.DeliveryStatus;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;
import com.sprint.entities.Guard;
import com.sprint.entities.SecurityAlert;
import com.sprint.entities.Vehicle;
import com.sprint.entities.VehicleUpdates;
import com.sprint.entities.Visitor;
import com.sprint.repositories.IVehicleRepository;
import com.sprint.services.IDeliveryService;
import com.sprint.services.IDomesticHelpService;
import com.sprint.services.IGuardService;
import com.sprint.services.ISecurityAlertService;
import com.sprint.services.IVehicleService;
import com.sprint.services.IVisitorService;


@RestController 
@RequestMapping("api/v1/")
public class GuardController {

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
	
	@PatchMapping("guard/Attendance")
	public ResponseEntity<Guard>updateGuardAttendance(@PathVariable Long id,@RequestParam LocalDateTime inTime,@RequestParam LocalDateTime outTime) 
	{
		return new ResponseEntity<Guard>(guardService.updateGuardAttendance(id, inTime, outTime),HttpStatus.OK);
	}

	@PatchMapping("guard/Id")
	public ResponseEntity<Guard>updateGuardById(@PathVariable Long id,@PathVariable Long mobilenumber)
	{
		return new ResponseEntity<Guard>(guardService.updateGuardById(id, mobilenumber),HttpStatus.OK);
	}

	//////////////////////--------------------SECURITY ALERTS----------------------------///////////////////

	@GetMapping("guard/securityAlert")
	public ResponseEntity<List<SecurityAlert>> getAllSecurityAlert()
	{
		return new ResponseEntity<List<SecurityAlert>>(securityAlertService.getSecurityAlertList(),HttpStatus.OK);
	}

	@GetMapping("guard/securityAlert/{id}")
	public ResponseEntity<SecurityAlert> getSecurityAlertById(@PathVariable Long id)
	{
		return new ResponseEntity<SecurityAlert>(securityAlertService.getSecurityAlertById(id),HttpStatus.OK);
	}

	@PostMapping("guard/securityAlert")
	public ResponseEntity<SecurityAlert> addSecurityAlert(@RequestBody SecurityAlert securityAlert)
	{
		return new ResponseEntity<SecurityAlert>(securityAlertService.addSecurityAlert(securityAlert),HttpStatus.CREATED);
	}


	@PatchMapping("guard/securityAlert/{id}")
	public ResponseEntity<SecurityAlert> updateSecurityAlertMessage(@PathVariable Long id, @RequestParam String oldMessage, @RequestParam String newMessage)
	{
		return new ResponseEntity<SecurityAlert>(securityAlertService.updateSecurityAlertById(id, oldMessage, newMessage),HttpStatus.OK);
	}

	@PutMapping("guard/securityAlert")
	public ResponseEntity<SecurityAlert> updateSecurityAlert(@RequestBody SecurityAlert securityAlert)
	{
		return new ResponseEntity<SecurityAlert>(securityAlertService.updateSecurityAlert(securityAlert),HttpStatus.OK);
	}
	////////////////////////////////////////////////////---------------DELIVERY --------------------///////////////////////////

	@GetMapping("guard/delivery")
	public ResponseEntity<List<Delivery>> getAllDeliveries()
	{
		return new ResponseEntity<List<Delivery>>(deliveryService.getDeliveryList(),HttpStatus.OK);
	}

	@GetMapping("guard/delivery/{id}")
	public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id)
	{
		return new ResponseEntity<Delivery>(deliveryService.getDeliveryById(id),HttpStatus.OK);
	}

	@PostMapping("guard/delivery")
	public ResponseEntity<Delivery> addDelivery(@RequestBody Delivery delivery)
	{
		return new ResponseEntity<Delivery>(deliveryService.addDelivery(delivery),HttpStatus.CREATED);
	}

	@PutMapping("guard/delivery")
	public ResponseEntity<Delivery> updateDelivery(@RequestBody Delivery delivery)
	{
		return new ResponseEntity<Delivery>(deliveryService.updateDelivery(delivery),HttpStatus.OK);
	}

	@PatchMapping("guard/delivery/{id}")
	public ResponseEntity<Delivery> updateDeliveryStatusById(@PathVariable Long id, @RequestParam DeliveryStatus oldStatus, @RequestParam DeliveryStatus newStatus)
	{
		return new ResponseEntity<Delivery>(deliveryService.updateDeliveryById(id, oldStatus, newStatus),HttpStatus.OK);
	}

	//----------------------------------DOMESTICHELP--------------------------------------------------------------
	//list all domesticHelps
	@GetMapping("guard/domesticHelps")
	public ResponseEntity<List<DomesticHelp>> getDomesticHelpList() {

		return new ResponseEntity<List<DomesticHelp>>(domesticHelpService.getDomesticHelpList(),HttpStatus.OK);
	}


	//get domesticHelp by id
	@GetMapping("guard/domesticHelps/{id}")
	public ResponseEntity<DomesticHelp> getDomesticHelpById(@PathVariable("id") Long id) {

		return new ResponseEntity<DomesticHelp>(domesticHelpService.getDomesticHelpById(id),HttpStatus.OK);
	}


	//add domesticHelp
	@PostMapping("guard/domesticHelps")
	public ResponseEntity<DomesticHelp> addDomesticHelp(@RequestBody DomesticHelp domsticHelp) {

		return new ResponseEntity<DomesticHelp>(domesticHelpService.addDomesticHelp(domsticHelp),HttpStatus.CREATED);
	}


	//update domesticHelp
	@PutMapping("guard/domesticHelps")
	public ResponseEntity<DomesticHelp> updateDomesticHelp(@RequestBody DomesticHelp domsticHelp) {

		return new ResponseEntity<DomesticHelp>(domesticHelpService.updateDomesticHelp(domsticHelp),HttpStatus.OK);
	}


	//update domesticHelp by id
	@PatchMapping("guard/domesticHelps/{id}")
	public ResponseEntity<DomesticHelp> updateDomesticHelpById(@PathVariable("id") Long id,@RequestParam DomesticHelpType oldHelpType,@RequestParam DomesticHelpType newHelpType) {

		return new ResponseEntity<DomesticHelp>(domesticHelpService.updateDomesticHelpById(id,oldHelpType,newHelpType),HttpStatus.OK);
	}

	//update domestichelp attendance
	@PostMapping("guard/domesticHelps/{id}/{domesticHelpId}")
	public ResponseEntity<DomesticHelp> updateAttendance(@PathVariable("domesticHelpId") Long domesticHelpId,@RequestBody Attendance attendance) {

		return new ResponseEntity<DomesticHelp>(domesticHelpService.updateAttendance(domesticHelpId,attendance),HttpStatus.OK);
	}

	//------------------------------------------VISITOR--------------------------------------------------------------------

	@GetMapping("guard/visitor")
	public ResponseEntity<List<Visitor>> getVisitorList()
	{
		return new ResponseEntity<List<Visitor>>(visitorService.getVisitorList(),HttpStatus.OK);
	}	

	@PostMapping("guard/visitor")
	public ResponseEntity<Visitor> addVisitor(@RequestBody Visitor visitor)
	{
		return new ResponseEntity<Visitor>(visitorService.addVisitor(visitor),HttpStatus.CREATED);
	}

	@PutMapping("guard/visitor")
	public ResponseEntity<Visitor>updateVisitor(@RequestBody Visitor visitor )
	{
		return new ResponseEntity<Visitor>(visitorService.updateVisitor(visitor),HttpStatus.OK);
	}

	@GetMapping("guard/visitor/{id}")
	public ResponseEntity<Visitor>getvisitorById(@PathVariable Long id)
	{
		return new ResponseEntity<Visitor>(visitorService.getVisitorById(id),HttpStatus.OK);
	}

	@PatchMapping("guard/visitor/{id}")
	public ResponseEntity<Visitor>updateVisitorById(@PathVariable Long id,@RequestParam String visitorname,String mobilenumber)
	{
		return new ResponseEntity<Visitor>(visitorService.updateVisitorById(id, visitorname, mobilenumber),HttpStatus.OK);
	}

	@DeleteMapping("guard/visitor")
	public ResponseEntity<Visitor>deleteVisitor(@RequestBody Visitor visitor)
	{
		return new ResponseEntity<Visitor>(visitorService.deleteVisitor(visitor),HttpStatus.OK);
	}


	@DeleteMapping("guard/visitor/{id}")
	public ResponseEntity<Visitor>deleteVisitorById(@PathVariable Long id)
	{
		return new ResponseEntity<Visitor>(visitorService.deleteVisitorById(id),HttpStatus.OK);	
	}

/////////////////////////////-----------LOGIN-------------
	@PostMapping("guard/login")
	public ResponseEntity<Guard> LoginGuard(@RequestBody Guard guard)
	{
		return new ResponseEntity<Guard>((Guard) guardService.Login(guard.getEmailId(), guard.getPassword(), guard.getRole()),HttpStatus.OK);
	}

	//////////////////////------------------------------VEHICLE UPDATES----------------------------------------///////////

	@PostMapping("guard/vehicleUpdates/{vehicleId}")
	public ResponseEntity<Vehicle> updateVehicleUpdate(@PathVariable("vehicleId") Long vehicleId,@RequestBody VehicleUpdates vUpdate) {

		return new ResponseEntity<Vehicle>(vehicleService.updateVehicleUpdate(vehicleId,vUpdate),HttpStatus.OK);
	}

	//get vehileUpdates by vehicleNumber
	@GetMapping("guard/vehicleUpdates/{numberPlate}")
	public ResponseEntity<Vehicle> findByNumberPlate(@PathVariable("vehicleNumber") String numberPlate) {

		return new ResponseEntity<Vehicle>(vehicleRepository.findByNumberPlate(numberPlate),HttpStatus.OK);
	}

	//get vehicles by id
	@GetMapping("guard/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehiclesById(@PathVariable("id") Long id) {

		return new ResponseEntity<Vehicle>(vehicleService.getVehiclesById(id),HttpStatus.OK);
	}
	
	////VIEW GUARD SALARIES,GUARD SHIFT
}