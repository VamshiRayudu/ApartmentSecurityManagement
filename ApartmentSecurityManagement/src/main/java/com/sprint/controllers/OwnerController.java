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
import com.sprint.entities.Delivery;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.FlatDetails;
import com.sprint.entities.Guard;
import com.sprint.entities.Owner;
import com.sprint.entities.SecurityAlert;
import com.sprint.entities.Vehicle;
import com.sprint.entities.Visitor;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IFlatDetailsRepository;
import com.sprint.repositories.IGuardRepository;
import com.sprint.repositories.IOwnerRepository;
import com.sprint.repositories.IVehicleRepository;
import com.sprint.services.FlatDetailsServiceImpl;
import com.sprint.services.IAdminService;
import com.sprint.services.IDeliveryService;
import com.sprint.services.IDomesticHelpService;
import com.sprint.services.IGuardService;
import com.sprint.services.IOwnerService;
import com.sprint.services.ISecurityAlertService;
import com.sprint.services.IVehicleService;
import com.sprint.services.IVisitorService;

/**
 * @authors NIJAGNA, KUNDANA PRIYA
 *
 */
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
	private IVehicleRepository vehicleRepository;

	@Autowired
	private IDomesticHelpService domesticHelpService;

	@Autowired
	private IFlatDetailsRepository flatDetailsRepository;

	@Autowired
	private ISecurityAlertService securityAlertService;

	@Autowired
	private IVehicleService vehicleService;

	@Autowired
	private FlatDetailsServiceImpl flatDetailsService;

	@Autowired
	private IOwnerService ownerService;
	
	@Autowired
	private IOwnerRepository ownerRepository;

	/**
	 * @param owner
	 * @return ResponseEntity<Owner>
	 * @throws UserNotFoundException 
	 */
	@PostMapping("owner/login")
	public ResponseEntity<Owner> LoginOwner(@RequestBody Owner owner) throws UserNotFoundException {
		LOGGER.info("LoginOwner URL is opened");
		LOGGER.info("LoginOwner() is initiated");
		Optional<Owner> user = ownerRepository.findById(owner.getId());
		if (user.get().getEmailId() != null) {
			if(user.get().getPassword().equals(owner.getPassword()))
			{
				return new ResponseEntity<Owner>(user.get(), HttpStatus.OK);
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
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return ResponseEntity<Owner>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("owner/{id}")
	public ResponseEntity<Owner> updateOwnerPassword(@Valid @PathVariable Long id, @RequestParam String oldPassword,
			@RequestParam String newPassword)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateOwnerPassword URL is opened");
		LOGGER.info("updateOwnerPassword() is initiated");
		return new ResponseEntity<Owner>(ownerService.updateOwnerById(id,oldPassword,newPassword), HttpStatus.OK);
	}

	/**
	 * @param flatNumber
	 * @return ResponseEntity<FlatDetails>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("owner/flatDetails/getByFlatNumber")
	public ResponseEntity<FlatDetails> getFlatDetailsById(@Valid @RequestParam Long flatNumber)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getFlatDetailsById URL is opened");
		LOGGER.info("getFlatDetailsById() is initiated");
		FlatDetails flat = flatDetailsService.getFlatDetailsById(flatNumber);
		return new ResponseEntity<FlatDetails>(flat, HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<FlatDetails>>
	 */
	@GetMapping("owner/flatDetails")
	public ResponseEntity<List<FlatDetails>> getFlatDetails() {
		LOGGER.info("getFlatDetails URL is opened");
		LOGGER.info("getFlatDetails() is initiated");
		List<FlatDetails> flat = flatDetailsService.listAllFlatDetails();
		return new ResponseEntity<List<FlatDetails>>(flat, (HttpStatus.OK));
	}

	/**
	 * @param flatNumber
	 * @param ownerDetails
	 * @return ResponseEntity<FlatDetails>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("owner/flatDetails/{flatNumber}")
	public ResponseEntity<FlatDetails> updateFlatDetails(@Valid @PathVariable("flatNumber") Long flatNumber,
			@RequestBody Owner ownerDetails) throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateFlatDetails URL is opened");
		LOGGER.info("updateFlatDetails() is initiated");
		return new ResponseEntity<FlatDetails>(flatDetailsService.updateFlatDetails(flatNumber, ownerDetails),
				HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Admin>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("owner/admin/getAdminById")
	public ResponseEntity<Admin> getAdminById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getAdminById URL is opened");
		LOGGER.info("getAdminById() is initiated");
		return new ResponseEntity<Admin>(adminService.getAdminById(id), HttpStatus.OK);
	}

	/**
	 * @param name
	 * @return ResponseEntity<List<Admin>>
	 */
	@GetMapping("owner/admin/getAdminByName")
	public ResponseEntity<List<Admin>> getAdminByName(@Valid @RequestParam String name) {
		LOGGER.info("getAdminByName URL is opened");
		LOGGER.info("getAdminByName() is initiated");
		return new ResponseEntity<List<Admin>>(adminRepository.findByName(name), HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<Admin>>
	 */
	@GetMapping("owner/admin")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		LOGGER.info("getAllAdmins URL is opened");
		LOGGER.info("getAllAdmins() is initiated");
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmins(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Delivery>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("owner/delivery/{id}")
	public ResponseEntity<Delivery> getDeliveryById(@Valid @PathVariable Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getDeliveryById URL is opened");
		LOGGER.info("getDeliveryById() is initiated");
		return new ResponseEntity<Delivery>(deliveryService.getDeliveryById(id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Vehicle>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("owner/vehicles/getVehicleById")
	public ResponseEntity<Vehicle> getVehiclesById(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getVehiclesById URL is opened");
		LOGGER.info("getVehiclesById() is initiated");
		return new ResponseEntity<Vehicle>(vehicleService.getVehiclesById(id), HttpStatus.OK);
	}

	/**
	 * @param vehicle
	 * @return ResponseEntity<Vehicle>
	 */
	@PostMapping("owner/vehicles")
	public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) {
		LOGGER.info("addVehicle URL is opened");
		LOGGER.info("addVehicle() is initiated");
		return new ResponseEntity<Vehicle>(vehicleService.addVehicle(vehicle), HttpStatus.CREATED);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Vehicle>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("owner/vehicles/{id}")
	public ResponseEntity<Vehicle> deleteVehicleById(@Valid @PathVariable("id") Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("deleteVehicleById URL is opened");
		LOGGER.info("deleteVehicleById() is initiated");
		return new ResponseEntity<Vehicle>(vehicleService.deleteVehicleById(id), HttpStatus.OK);
	}

	/**
	 * @param numberPlate
	 * @return ResponseEntity<Vehicle>
	 */
	@GetMapping("owner/vehicleUpdates/getByVehicleNumber")
	public ResponseEntity<Vehicle> findByNumberPlate(@Valid @RequestParam String numberPlate) {

		LOGGER.info("findByNumberPlate URL is opened");
		LOGGER.info("findByNumberPlate() is initiated");
		return new ResponseEntity<Vehicle>(vehicleRepository.findByNumberPlate(numberPlate), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<List<Visitor>>
	 */
	@GetMapping("guard/visitor/getVisitorListByFlatNumber")
	public ResponseEntity<List<Visitor>> getVisitorListByFlatNumber(@Valid @RequestParam Long id) {
		FlatDetails fd = flatDetailsRepository.getById(id);
		return new ResponseEntity<List<Visitor>>(fd.getVisitors(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Visitor>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("owner/visitor/{id}")
	public ResponseEntity<Visitor> getvisitorById(@Valid @PathVariable Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getvisitorById URL is opened");
		LOGGER.info("getvisitorById() is initiated");
		return new ResponseEntity<Visitor>(visitorService.getVisitorById(id), HttpStatus.OK);
	}

	/**
	 * @param name
	 * @return ResponseEntity<List<Guard>>
	 */
	@GetMapping("owner/guard/getGuardByName")
	public ResponseEntity<List<Guard>> findByGuardName(@Valid @RequestParam String name) {
		LOGGER.info("findByGuardName URL is opened");
		LOGGER.info("findByGuardName() is initiated");
		return new ResponseEntity<List<Guard>>(guardRepository.findByName(name), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Guard>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("owner/guard/getGuardById")
	public ResponseEntity<Guard> getGuardById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getGuardById URL is opened");
		LOGGER.info("getGuardById() is initiated");
		return new ResponseEntity<Guard>(guardService.getGuardById(id), HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<Guard>>
	 */
	@GetMapping("owner/guard")
	public ResponseEntity<List<Guard>> getAllGuards() {
		LOGGER.info("getAllGuards URL is opened");
		LOGGER.info("getAllGuards() is initiated");
		return new ResponseEntity<List<Guard>>(guardService.getAllGuards(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<DomesticHelp>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("owner/domesticHelps/{id}")
	public ResponseEntity<DomesticHelp> getDomesticHelpById(@Valid @PathVariable("id") Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getDomesticHelpById URL is opened");
		LOGGER.info("getDomesticHelpById() is initiated");
		return new ResponseEntity<DomesticHelp>(domesticHelpService.getDomesticHelpById(id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<List<DomesticHelp>>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("owner/domesticHelps/getDomesticHelpByFlatId/{id}")
	public ResponseEntity<List<DomesticHelp>> getDomesticHelpByFlatId(@Valid @PathVariable Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getDomesticHelpByFlatId URL is opened");
		LOGGER.info("getDomesticHelpByFlatId() is initiated");
		FlatDetails fd = flatDetailsRepository.getById(id);
		return new ResponseEntity<List<DomesticHelp>>(fd.getdHelpList(), HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<SecurityAlert>>
	 */
	@GetMapping("owner/securityAlert")
	public ResponseEntity<List<SecurityAlert>> getAllSecurityAlert() {
		LOGGER.info("getAllSecurityAlert URL is opened");
		LOGGER.info("getAllSecurityAlert() is initiated");
		return new ResponseEntity<List<SecurityAlert>>(securityAlertService.getSecurityAlertList(), HttpStatus.OK);
	}

	
	/**
	 * @param id
	 * @return ResponseEntity<Owner>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 * @throws UserNotFoundException
	 */
	@GetMapping("owner/getAllVehiclesByOwnerId")
	public ResponseEntity<List<Vehicle>> getAllVehiclesByOwnerId(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException, UserNotFoundException {

		LOGGER.info("getAllVehiclesByOwnerId URL is opened");
		LOGGER.info("getAllVehiclesByOwnerId() is initiated");
		Owner owner = ownerService.getOwnerById(id);
		return new ResponseEntity<List<Vehicle>>(owner.getVehicleDetails(), HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return ResponseEntity<Owner>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 * @throws UserNotFoundException
	 */
	@GetMapping("owner/getAllFlatDetailsByOwnerId")
	public ResponseEntity<List<FlatDetails>> getAllFlatDetailsByOwnerId(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException, UserNotFoundException {

		LOGGER.info("getAllFlatDetailsByOwnerId URL is opened");
		LOGGER.info("getAllFlatDetailsByOwnerId() is initiated");
		Owner owner = ownerService.getOwnerById(id);
		return new ResponseEntity<List<FlatDetails>>(owner.getFlatDetails(), HttpStatus.OK);
	}
}