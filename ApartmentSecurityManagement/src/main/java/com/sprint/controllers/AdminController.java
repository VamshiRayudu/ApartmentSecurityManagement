package com.sprint.controllers;

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

import com.sprint.entities.Admin;
import com.sprint.entities.Delivery;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.FlatDetails;
import com.sprint.entities.Guard;
import com.sprint.entities.Owner;
import com.sprint.entities.SecurityAlert;
import com.sprint.entities.Vehicle;
import com.sprint.entities.Visitor;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IGuardRepository;
import com.sprint.services.IAdminService;
import com.sprint.services.IDeliveryService;
import com.sprint.services.IDomesticHelpService;
import com.sprint.services.IFlatDetailsService;
import com.sprint.services.IGuardService;
import com.sprint.services.IOwnerService;
import com.sprint.services.ISecurityAlertService;
import com.sprint.services.IVehicleService;
import com.sprint.services.IVisitorService;

@RestController 
@RequestMapping("api/v1/")
public class AdminController {

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
	private ISecurityAlertService securityAlertService;

	@Autowired
	private IDeliveryService deliveryService;

	@Autowired
	private IDomesticHelpService domesticHelpService;

	@Autowired
	private IFlatDetailsService flatDetailsService;

	@Autowired
	private IOwnerService ownerService;
	
	@Autowired
	private IVehicleService vehicleService;

	@PostMapping("admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws DuplicateRecordException
	{
		return new ResponseEntity<Admin>(adminService.addAdmin(admin),HttpStatus.CREATED);
	}

	@PostMapping("admin/login")
	public ResponseEntity<Admin> LoginAdmin(@RequestBody Admin admin)
	{
		return new ResponseEntity<Admin>((Admin) adminService.Login(admin.getEmailId(), admin.getPassword(), admin.getRole()),HttpStatus.OK);
	}

	@GetMapping("admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Long id) throws UserNotFoundException
	{
		return new ResponseEntity<Admin>(adminService.getAdminById(id),HttpStatus.OK);
	}

	@GetMapping("admin/{name}")
	public ResponseEntity<List<Admin>> getAdminByName(@PathVariable String name)
	{
		return new ResponseEntity<List<Admin>>(adminRepository.findByName(name),HttpStatus.OK);
	}

	@GetMapping("admin")
	public ResponseEntity<List<Admin>> getAllAdmins()
	{
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmins(),HttpStatus.OK);
	}

	@DeleteMapping("admin/{id}")
	public ResponseEntity<Admin> deleteAdminById(@PathVariable Long id) throws UserNotFoundException
	{
		return new ResponseEntity<Admin>(adminService.deleteAdminById(id),HttpStatus.OK);
	}

	@DeleteMapping("admin")
	public ResponseEntity<Admin> deleteAdmin(@RequestBody Admin admin) throws UserNotFoundException
	{
		return new ResponseEntity<Admin>(adminService.deleteAdmin(admin),HttpStatus.OK);
	}

	@PutMapping("admin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) throws UserNotFoundException
	{
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin),HttpStatus.OK);
	}

	@PatchMapping("admin/{id}")
	public ResponseEntity<Admin> updateAdminPassword(@PathVariable Long id, @RequestParam String oldPassword, @RequestParam String newPassword) throws UserNotFoundException
	{
		return new ResponseEntity<Admin>(adminService.updateAdminById(id, oldPassword, newPassword),HttpStatus.OK);
	}


	////////////////////////////----------------ADMIN OPERATION ON GUARD----------------------------//////////////////////


	@PostMapping("admin/guard")
	public ResponseEntity<Guard> addGuard(@RequestBody Guard guard) throws DuplicateRecordException
	{
		return new ResponseEntity<Guard>(guardService.addGuard(guard),HttpStatus.CREATED);
	}

	@GetMapping("admin/guard/{name}")
	public ResponseEntity< List<Guard>> findByGuardName(@PathVariable String name)
	{
		return new ResponseEntity<List<Guard>>(guardRepository.findByName(name),HttpStatus.OK);
	}

	@GetMapping ("admin/guard/{id}")
	public ResponseEntity<Guard> getGuardById(@PathVariable Long id) throws UserNotFoundException
	{
		return new ResponseEntity<Guard>(guardService.getGuardById(id),HttpStatus.OK);
	}

	@GetMapping("admin/guard")
	public ResponseEntity<List<Guard>> getAllGuards()
	{
		return new ResponseEntity<List<Guard>>(guardService.getAllGuards(),HttpStatus.OK);
	}

	@DeleteMapping("admin/guard")
	public ResponseEntity<Guard> deleteGuard(@RequestBody Guard guard) throws UserNotFoundException
	{
		return new ResponseEntity<Guard>(guardService.deleteGuard(guard),HttpStatus.OK);
	}

	@DeleteMapping("admin/guard/{id}")
	public ResponseEntity<Guard> deleteGuardById(@PathVariable Long id) throws UserNotFoundException
	{
		return new ResponseEntity<Guard>(guardService.deleteGuardById(id),HttpStatus.OK);	
	}

	@PutMapping("admin/guard")
	public ResponseEntity<Guard> updateGuard(@RequestBody Guard guard) throws UserNotFoundException
	{
		return new ResponseEntity<Guard>(guardService.updateGuard(guard),HttpStatus.OK);
	}

	@PatchMapping("admin/guard/{id}")
	public ResponseEntity<Guard> updateGuardById(@PathVariable Long id,@RequestParam Long oldMobilenumber, @RequestParam Long newMobileNumber) throws UserNotFoundException
	{
		return new ResponseEntity<Guard>(guardService.updateGuardById(id, oldMobilenumber, newMobileNumber),HttpStatus.OK);
	}

	/////////////////////////-----------------VISITOR----------------------------//////////////////////////

	@GetMapping("admin/visitor")
	public ResponseEntity<List<Visitor>> getVisitorList()
	{
		return new ResponseEntity<List<Visitor>>(visitorService.getVisitorList(),HttpStatus.OK);
	}	

	/////////////////////////---------------------SECURITY ALERTS ------------------------------/////////

	@PostMapping("admin/{id}/securityAlert") ///Add To adminRepo
	public ResponseEntity<SecurityAlert> addSecurityAlert(@RequestBody SecurityAlert securityAlert) throws DuplicateRecordException
	{
		return new ResponseEntity<SecurityAlert>(securityAlertService.addSecurityAlert(securityAlert),HttpStatus.CREATED);
	}

	@GetMapping("admin/securityAlert")
	public ResponseEntity<List<SecurityAlert>> getAllSecurityAlert()
	{
		return new ResponseEntity<List<SecurityAlert>>(securityAlertService.getSecurityAlertList(),HttpStatus.OK);
	}

	@GetMapping("admin/securityAlert/{id}")
	public ResponseEntity<SecurityAlert> getSecurityAlertById(@PathVariable Long id) throws RecordNotFoundException
	{
		return new ResponseEntity<SecurityAlert>(securityAlertService.getSecurityAlertById(id),HttpStatus.OK);
	}

	@DeleteMapping("admin/{id}/securityAlert/{id}")
	public ResponseEntity<SecurityAlert> deleteSecurityAlertById(@PathVariable Long id) throws RecordNotFoundException
	{
		return new ResponseEntity<SecurityAlert>(securityAlertService.deleteSecurityAlertById(id),HttpStatus.OK);
	}

	@PatchMapping("admin/{id}/securityAlert/{id}")
	public ResponseEntity<SecurityAlert> updateSecurityAlertMessage(@PathVariable Long id, @RequestParam String oldMessage, @RequestParam String newMessage) throws RecordNotFoundException
	{
		return new ResponseEntity<SecurityAlert>(securityAlertService.updateSecurityAlertById(id, oldMessage, newMessage),HttpStatus.OK);
	}

	@PutMapping("admin/{id}/securityAlert")
	public ResponseEntity<SecurityAlert> updateSecurityAlert(@RequestBody SecurityAlert securityAlert) throws RecordNotFoundException
	{
		return new ResponseEntity<SecurityAlert>(securityAlertService.updateSecurityAlert(securityAlert),HttpStatus.OK);
	}

	////////////////-----------------------------------DELIVERY---------------------------------------------

	@GetMapping("admin/delivery")
	public ResponseEntity<List<Delivery>> getAllDeliveries()
	{
		return new ResponseEntity<List<Delivery>>(deliveryService.getDeliveryList(),HttpStatus.OK);
	}

	@GetMapping("admin/delivery/{id}")
	public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) throws RecordNotFoundException
	{
		return new ResponseEntity<Delivery>(deliveryService.getDeliveryById(id),HttpStatus.OK);
	}

	//////////////////////////////---------------------------DOMESTIC HELP----------------------------------------------

	@GetMapping("admin/domesticHelps")
	public ResponseEntity<List<DomesticHelp>> getDomesticHelpList() {

		return new ResponseEntity<List<DomesticHelp>>(domesticHelpService.getDomesticHelpList(),HttpStatus.OK);
	}

	//get domesticHelp by id
	@GetMapping("admin/domesticHelps/{id}")
	public ResponseEntity<DomesticHelp> getDomesticHelpById(@PathVariable("id") Long id) throws UserNotFoundException {

		return new ResponseEntity<DomesticHelp>(domesticHelpService.getDomesticHelpById(id),HttpStatus.OK);
	}

	/////////////////////////////////////////------FLATDETAILS-------------------------------------------

	@PostMapping("admin/flatDetails")
	public ResponseEntity<FlatDetails> addFlatDetails(@RequestBody FlatDetails flatDetails) throws DuplicateRecordException{

		FlatDetails flat = flatDetailsService.addFlatDetails(flatDetails);
		return new ResponseEntity<FlatDetails>(flat,HttpStatus.CREATED);
	}

	@GetMapping("admin/flatDetails/{flatNumber}")
	public ResponseEntity<FlatDetails> getFlatDetails(@PathVariable("flatNumber") Long flatNumber) throws RecordNotFoundException
	{
		FlatDetails flat = flatDetailsService.getFlatDetailsById(flatNumber);
		return new ResponseEntity<FlatDetails>(flat,HttpStatus.OK);
	}

	@GetMapping("admin/owner/flatDetails")
	public ResponseEntity<List<FlatDetails>> getFlatDetails()
	{
		List<FlatDetails> flat = flatDetailsService.listAllFlatDetails();
		return new ResponseEntity<List<FlatDetails>>(flat,(HttpStatus.OK));
	}


	@PatchMapping("admin/flatDetails/{flatNumber}")
	public ResponseEntity<FlatDetails> updateFlatDetails(@PathVariable("flatNumber") Long flatNumber,@RequestParam Owner ownerDetails) throws RecordNotFoundException
	{
		return new ResponseEntity<FlatDetails>(flatDetailsService.updateFlatDetails(flatNumber,ownerDetails),HttpStatus.OK);		
	}

	///////////////////////////////---------------------ONWER DETAILS----------------
	@PostMapping("admin/{id}/owner")
	public ResponseEntity<Owner> addOwner(@RequestBody 	Owner owner) throws DuplicateRecordException
	{
		return new ResponseEntity<Owner>(ownerService.addOwner(owner),HttpStatus.CREATED);
	}

	@DeleteMapping("admin/{id}/owner/{id}")
	public ResponseEntity<Owner> deleteData1(@PathVariable("id") Long id) throws UserNotFoundException{

		Owner owner = ownerService.deleteOwnerById(id);
		owner = ownerService.deleteOwner(owner);
		return new ResponseEntity<Owner>(owner,HttpStatus.OK);
	}

	@PutMapping("admin/{id}/owner")
	public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner) throws UserNotFoundException
	{
		return new ResponseEntity<Owner>(ownerService.updateOwner( owner),HttpStatus.OK);
	}

	///////////////////////////////-------------------------VEHICLE------------------------------------------------
	//get vehicles by id
	@GetMapping("admin/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehiclesById(@PathVariable("id") Long id) throws RecordNotFoundException {

		return new ResponseEntity<Vehicle>(vehicleService.getVehiclesById(id),HttpStatus.OK);
	}

}
