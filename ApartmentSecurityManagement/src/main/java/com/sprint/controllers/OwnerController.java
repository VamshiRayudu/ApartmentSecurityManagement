package com.sprint.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
	public ResponseEntity<Owner> LoginAdmin(@RequestBody Owner owner)
	{
		return new ResponseEntity<Owner>((Owner) ownerService.Login(owner.getEmailId(), owner.getPassword(), owner.getRole()),HttpStatus.OK);
	}
	
	/////////////////////--------------FLAT--------------
	
	@GetMapping("owner/flatDetails/{flatNumber}")
	public ResponseEntity<FlatDetails> getFlatDetails(@PathVariable("flatNumber") Long flatNumber)
	{
		FlatDetails flat = flatDetailsService.getFlatDetailsById(flatNumber);
		return new ResponseEntity<FlatDetails>(flat,HttpStatus.OK);
	}
	
	@GetMapping("owner/flatDetails")
	public ResponseEntity<List<FlatDetails>> getFlatDetails()
	{
		List<FlatDetails> flat = flatDetailsService.listAllFlatDetails();
		return new ResponseEntity<List<FlatDetails>>(flat,(HttpStatus.OK));
	}
	
	@PatchMapping("owner/flatDetails/{flatNumber}")
	public ResponseEntity<FlatDetails> updateFlatDetails(@PathVariable("flatNumber") Long flatNumber,@RequestParam Owner ownerDetails)
	{
		return new ResponseEntity<FlatDetails>(flatDetailsService.updateFlatDetails(flatNumber,ownerDetails),HttpStatus.OK);		
	}
		
	//////////////////////-------------------ADMINS--------------------------/////////////////////////////-

	@GetMapping("owner/admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Long id) throws UserNotFoundException
	{
		return new ResponseEntity<Admin>(adminService.getAdminById(id),HttpStatus.OK);
	}
	
	@GetMapping("owner/admin/{name}")
	public ResponseEntity<List<Admin>> getAdminByName(@PathVariable String name)
	{
		return new ResponseEntity<List<Admin>>(adminRepository.findByName(name),HttpStatus.OK);
	}
	
	@GetMapping("owner/admin")
	public ResponseEntity<List<Admin>> getAllAdmins()
	{
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmins(),HttpStatus.OK);
	}
	
	////////////////////////////---------------DELIVERIES-------------------------------------------------

	@GetMapping("owner/delivery/{id}")
	public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id)
	{
		return new ResponseEntity<Delivery>(deliveryService.getDeliveryById(id),HttpStatus.OK);
	}
	
	////////////////////////////////------------------VEHICLES----------------------------------------------
	//get vehicles by id
	@GetMapping("owner/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehiclesById(@PathVariable("id") Long id) {
		
		return new ResponseEntity<Vehicle>(vehicleService.getVehiclesById(id),HttpStatus.OK);
	}
	
	
	//add a vehicle
	@PostMapping("owner/vehicles")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		
		return new ResponseEntity<Vehicle>(vehicleService.addVehicle(vehicle),HttpStatus.CREATED);
	}
	
	
	//delete vehicle
	@DeleteMapping("owner/vehicles/{id}")
	public ResponseEntity<Vehicle> deleteVehicleById(@PathVariable("id") Long id) {
		
		return new ResponseEntity<Vehicle>(vehicleService.deleteVehicleById(id),HttpStatus.OK);
	}
	
	///////////////////////////////////////////--VISITOR----------------------------
//	@GetMapping("guard/visitor")
//	public ResponseEntity<List<Visitor>> getVisitorList()
//	{
//		return new ResponseEntity<List<Visitor>>(visitorService.getVisitorList(),HttpStatus.OK);
//	}	

	
	@GetMapping("owner/visitor/{id}")
	public ResponseEntity<Visitor>getvisitorById(@PathVariable Long id)
	{
		return new ResponseEntity<Visitor>(visitorService.getVisitorById(id),HttpStatus.OK);
	}
	
	
    //////////////////---------------------------GUARD------------------

	@GetMapping("owner/guard/{name}")
	public ResponseEntity< List<Guard>> findByGuardName(@PathVariable String name)
	{
		return new ResponseEntity<List<Guard>>(guardRepository.findByName(name),HttpStatus.OK);
	}
	
	@GetMapping ("owner/guard/{id}")
	public ResponseEntity<Guard> getGuardById(@PathVariable Long id)
	{
		return new ResponseEntity<Guard>(guardService.getGuardById(id),HttpStatus.OK);
	}
	
	@GetMapping("owner/guard")
	public ResponseEntity<List<Guard>> getAllGuards()
	{
		return new ResponseEntity<List<Guard>>(guardService.getAllGuards(),HttpStatus.OK);
	}
	
	/////////////-----------DOMESTIC HELP---------

	//get domesticHelp by id
	@GetMapping("owner/domesticHelps/{id}")
	public ResponseEntity<DomesticHelp> getDomesticHelpById(@PathVariable("id") Long id) {
		
		return new ResponseEntity<DomesticHelp>(domesticHelpService.getDomesticHelpById(id),HttpStatus.OK);
	}
	
	
}