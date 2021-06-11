package com.sprint.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
import com.sprint.entities.Delivery;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.FlatDetails;
import com.sprint.entities.Guard;
import com.sprint.entities.Owner;
import com.sprint.entities.Vehicle;
import com.sprint.entities.Visitor;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IGuardRepository;
import com.sprint.services.FlatDetailsServiceImpl;
import com.sprint.services.IAdminService;
import com.sprint.services.IDeliveryService;
import com.sprint.services.IDomesticHelpService;
import com.sprint.services.IGuardService;
import com.sprint.services.IOwnerService;
import com.sprint.services.IVehicleService;
import com.sprint.services.IVisitorService;


@RestController
@RequestMapping("api/v1/")
public class OwnerController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);
	
	@Autowired
	private IAdminService adminService;

	@Autowired
	private IAdminRepository adminRepository;

	@Autowired
	private IGuardService guardService;

	@Autowired
	private IGuardRepository guardRepository;

	@Autowired
	private IVisitorService visitorService;

	@Autowired
	private IDeliveryService deliveryService;

	@Autowired
	private IDomesticHelpService domesticHelpService;
	
	@Autowired
	private IVehicleService vehicleService;

	@Autowired
	private FlatDetailsServiceImpl flatDetailsService;
	
	@Autowired
	private IOwnerService ownerService;
	
	
	@PostMapping("owner/login")
	public ResponseEntity<Owner> LoginOwner(@Valid @RequestBody Owner owner)
	{
		LOGGER.info("LoginOwner URL is opened");
		LOGGER.info("LoginOwner() is initiated");
		return new ResponseEntity<Owner>((Owner) ownerService.Login(owner.getEmailId(), owner.getPassword(), owner.getRole()),HttpStatus.OK);
	}
	
	/////////////////////--------------FLAT--------------
	
	@GetMapping("owner/flatDetails/getByFlatNumber")
	public ResponseEntity<FlatDetails> getFlatDetailsById(@Valid @RequestParam Long flatNumber) throws RecordNotFoundException, MethodArgumentNotValidException
	{
		LOGGER.info("getFlatDetailsById URL is opened");
		LOGGER.info("getFlatDetailsById() is initiated");
		FlatDetails flat = flatDetailsService.getFlatDetailsById(flatNumber);
		return new ResponseEntity<FlatDetails>(flat,HttpStatus.OK);
	}
	
	@GetMapping("owner/flatDetails")
	public ResponseEntity<List<FlatDetails>> getFlatDetails()
	{
		LOGGER.info("getFlatDetails URL is opened");
		LOGGER.info("getFlatDetails() is initiated");
		List<FlatDetails> flat = flatDetailsService.listAllFlatDetails();
		return new ResponseEntity<List<FlatDetails>>(flat,(HttpStatus.OK));
	}
	
	@PatchMapping("owner/flatDetails/{flatNumber}")
	public ResponseEntity<FlatDetails> updateFlatDetails(@Valid @PathVariable("flatNumber") Long flatNumber,@RequestBody Owner ownerDetails) throws RecordNotFoundException, MethodArgumentNotValidException
	{
		LOGGER.info("updateFlatDetails URL is opened");
		LOGGER.info("updateFlatDetails() is initiated");
		return new ResponseEntity<FlatDetails>(flatDetailsService.updateFlatDetails(flatNumber,ownerDetails),HttpStatus.OK);		
	}
		
	//////////////////////-------------------ADMINS--------------------------/////////////////////////////-

	@GetMapping("owner/admin/getAdminById")
	public ResponseEntity<Admin> getAdminById(@Valid @RequestParam Long id) throws UserNotFoundException, MethodArgumentNotValidException
	{
		LOGGER.info("getAdminById URL is opened");
		LOGGER.info("getAdminById() is initiated");
		return new ResponseEntity<Admin>(adminService.getAdminById(id),HttpStatus.OK);
	}
	
	@GetMapping("owner/admin/getAdminByName")
	public ResponseEntity<List<Admin>> getAdminByName(@Valid @RequestParam String name)
	{
		LOGGER.info("getAdminByName URL is opened");
		LOGGER.info("getAdminByName() is initiated");
		return new ResponseEntity<List<Admin>>(adminRepository.findByName(name),HttpStatus.OK);
	}
	
	@GetMapping("owner/admin")
	public ResponseEntity<List<Admin>> getAllAdmins()
	{
		LOGGER.info("getAllAdmins URL is opened");
		LOGGER.info("getAllAdmins() is initiated");
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmins(),HttpStatus.OK);
	}
	
	////////////////////////////---------------DELIVERIES-------------------------------------------------

	@GetMapping("owner/delivery/{id}")
	public ResponseEntity<Delivery> getDeliveryById(@Valid @PathVariable Long id) throws RecordNotFoundException, MethodArgumentNotValidException
	{
		LOGGER.info("getDeliveryById URL is opened");
		LOGGER.info("getDeliveryById() is initiated");
		return new ResponseEntity<Delivery>(deliveryService.getDeliveryById(id),HttpStatus.OK);
	}
	
	////////////////////////////////------------------VEHICLES----------------------------------------------
	//get vehicles by id
	@GetMapping("owner/vehicles/getVehicleById")
	public ResponseEntity<Vehicle> getVehiclesById(@Valid @RequestParam Long id) throws RecordNotFoundException , MethodArgumentNotValidException{
		LOGGER.info("getVehiclesById URL is opened");
		LOGGER.info("getVehiclesById() is initiated");
		return new ResponseEntity<Vehicle>(vehicleService.getVehiclesById(id),HttpStatus.OK);
	}
	
	
	//add a vehicle
	@PostMapping("owner/vehicles")
	public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) {
		LOGGER.info("addVehicle URL is opened");
		LOGGER.info("addVehicle() is initiated");
		return new ResponseEntity<Vehicle>(vehicleService.addVehicle(vehicle),HttpStatus.CREATED);
	}
	
	
	//delete vehicle
	@DeleteMapping("owner/vehicles/{id}")
	public ResponseEntity<Vehicle> deleteVehicleById(@Valid @PathVariable("id") Long id) throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("deleteVehicleById URL is opened");
		LOGGER.info("deleteVehicleById() is initiated");
		return new ResponseEntity<Vehicle>(vehicleService.deleteVehicleById(id),HttpStatus.OK);
	}
	
	///////////////////////////////////////////--VISITOR----------------------------
//	@GetMapping("guard/visitor")
//	public ResponseEntity<List<Visitor>> getVisitorList()
//	{
//		return new ResponseEntity<List<Visitor>>(visitorService.getVisitorList(),HttpStatus.OK);
//	}	

	
	@GetMapping("owner/visitor/{id}")
	public ResponseEntity<Visitor>getvisitorById(@Valid @PathVariable Long id) throws RecordNotFoundException, MethodArgumentNotValidException
	{
		LOGGER.info("getvisitorById URL is opened");
		LOGGER.info("getvisitorById() is initiated");
		return new ResponseEntity<Visitor>(visitorService.getVisitorById(id),HttpStatus.OK);
	}
	
	
    //////////////////---------------------------GUARD------------------

	@GetMapping("owner/guard/getGuardByName")
	public ResponseEntity< List<Guard>> findByGuardName(@Valid @RequestParam String name)
	{
		LOGGER.info("findByGuardName URL is opened");
		LOGGER.info("findByGuardName() is initiated");
		return new ResponseEntity<List<Guard>>(guardRepository.findByName(name),HttpStatus.OK);
	}
	
	@GetMapping ("owner/guard/getGuardById")
	public ResponseEntity<Guard> getGuardById(@Valid @RequestParam Long id) throws UserNotFoundException, MethodArgumentNotValidException
	{
		LOGGER.info("getGuardById URL is opened");
		LOGGER.info("getGuardById() is initiated");
		return new ResponseEntity<Guard>(guardService.getGuardById(id),HttpStatus.OK);
	}
	
	@GetMapping("owner/guard")
	public ResponseEntity<List<Guard>> getAllGuards()
	{
		LOGGER.info("getAllGuards URL is opened");
		LOGGER.info("getAllGuards() is initiated");
		return new ResponseEntity<List<Guard>>(guardService.getAllGuards(),HttpStatus.OK);
	}
	
	/////////////-----------DOMESTIC HELP---------

	//get domesticHelp by id
	@GetMapping("owner/domesticHelps/{id}")
	public ResponseEntity<DomesticHelp> getDomesticHelpById(@Valid @PathVariable("id") Long id) throws UserNotFoundException , MethodArgumentNotValidException{
		LOGGER.info("getDomesticHelpById URL is opened");
		LOGGER.info("getDomesticHelpById() is initiated");
		return new ResponseEntity<DomesticHelp>(domesticHelpService.getDomesticHelpById(id),HttpStatus.OK);
	}
	
	
}