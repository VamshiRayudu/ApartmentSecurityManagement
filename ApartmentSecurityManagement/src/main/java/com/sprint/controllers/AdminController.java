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
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.FlatDetails;
import com.sprint.entities.Guard;
import com.sprint.entities.GuardSalary;
import com.sprint.entities.GuardShift;
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

/**
 * @authors SAI VAMSI KRISHNA, VIVEK PABBA
 *
 */
@RestController
@RequestMapping("api/v1/")
public class AdminController {

	static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

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

	/**
	 * 
	 * @param admin
	 * @param adminId
	 * @return ResponseEntity<Admin>
	 * @throws DuplicateRecordException
	 * @throws MethodArgumentNotValidException
	 * @throws UserNotFoundException
	 */
	@PostMapping("admin")
	public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin admin, @RequestParam Long adminId)
			throws DuplicateRecordException, MethodArgumentNotValidException, UserNotFoundException {
		LOGGER.info("addAdmin URL is opened");
		LOGGER.info("addAdmin() is initiated");
		Optional<Admin> user = adminRepository.findById(adminId);
		if (user.get().getEmailId() != null) {
			return new ResponseEntity<Admin>(adminService.addAdmin(admin), HttpStatus.CREATED);
		} else {
			throw new UserNotFoundException("Not a valid Admin");
		}
	}

	/**
	 * 
	 * @param admin
	 * @return ResponseEntity<Admin>
	 * @throws UserNotFoundException
	 */
	@PostMapping("admin/login")
	public ResponseEntity<Admin> LoginAdmin(@RequestBody Admin admin) throws UserNotFoundException {
		LOGGER.info("LoginAdmin URL is opened");
		LOGGER.info("loginAdmin() is initiated");
		Optional<Admin> user = adminRepository.findById(admin.getId());
		if (user.get().getEmailId() != null) {
			if(user.get().getPassword().equals(admin.getPassword()))
			{
				return new ResponseEntity<Admin>(user.get(), HttpStatus.OK);
			}
			else
			{
				throw new ValidationException("Invalid Password");
			}
		} else {
			throw new UserNotFoundException("Not User Found");
		}
	}

	/**
	 * @param id
	 * @return ResponseEntity<Admin>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("admin/getAdminById")
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
	@GetMapping("admin/getAdminByName")
	public ResponseEntity<List<Admin>> getAdminByName(@Valid @RequestParam String name) {
		LOGGER.info("getAdminByName URL is opened");
		LOGGER.info("getAdminByName() is initiated");
		return new ResponseEntity<List<Admin>>(adminRepository.findByName(name), HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<Admin>>
	 */
	@GetMapping("admin/getAllAdmins")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		LOGGER.info("getAllAdmins URL is opened");
		LOGGER.info("getAllAdmins() is initiated");
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmins(), HttpStatus.OK);
	}

	/**
	 * @param adminId
	 * @param id
	 * @return ResponseEntity<Admin>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("admin/{adminId}")
	public ResponseEntity<Admin> deleteAdminById(@Valid @PathVariable(name = "adminId") Long adminId,
			@RequestParam Long id) throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("deleteAdminById URL is opened");
		LOGGER.info("deleteAdminById() is initiated");
		Optional<Admin> user = adminRepository.findById(adminId);
		if (user.get().getEmailId() != null) {
			return new ResponseEntity<Admin>(adminService.deleteAdminById(id), HttpStatus.OK);
		} else {
			throw new UserNotFoundException("Not a valid Admin");
		}
	}

	/**
	 * 
	 * @param admin
	 * @param adminId
	 * @return ResponseEntity<Admin>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("admin/")
	public ResponseEntity<Admin> deleteAdmin(@Valid @RequestBody Admin admin, @RequestParam Long adminId)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("deleteAdmin URL is opened");
		LOGGER.info("deleteAdmin() is initiated");
		Optional<Admin> user = adminRepository.findById(adminId);
		if (user.get().getEmailId() != null) {
			return new ResponseEntity<Admin>(adminService.deleteAdmin(admin), HttpStatus.OK);
		} else {
			throw new UserNotFoundException("Not a valid Admin");
		}
	}

	/**
	 * @param admin
	 * @return ResponseEntity<Admin>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PutMapping("admin")
	public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateAdmin URL is opened");
		LOGGER.info("updateAdmin() is initiated");
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return ResponseEntity<Admin>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("admin/{id}")
	public ResponseEntity<Admin> updateAdminPassword(@Valid @PathVariable Long id, @RequestParam String oldPassword,
			@RequestParam String newPassword) throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateAdminPassword URL is opened");
		LOGGER.info("updateAdminPassword() is initiated");
		return new ResponseEntity<Admin>(adminService.updateAdminById(id, oldPassword, newPassword), HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return ResponseEntity<List<SecurityAlert>>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("admin/getSecurityAlertsByAdminId")
	public ResponseEntity<List<SecurityAlert>> getSecurityAlertsByAdminId(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getAdminById URL is opened");
		LOGGER.info("getAdminById() is initiated");
		Admin adm = adminService.getAdminById(id);
		return new ResponseEntity<List<SecurityAlert>>(adm.getSecurityAlerts(), HttpStatus.OK);
	}

	/**
	 * @param guard
	 * @param adminId
	 * @return ResponseEntity<Guard>
	 * @throws DuplicateRecordException
	 * @throws MethodArgumentNotValidException
	 * @throws UserNotFoundException
	 */
	@PostMapping("admin/guard")
	public ResponseEntity<Guard> addGuard(@Valid @RequestBody Guard guard, @RequestParam Long adminId)
			throws DuplicateRecordException, MethodArgumentNotValidException, UserNotFoundException {
		LOGGER.info("addGuard URL is opened");
		LOGGER.info("addGuard() is initiated");
		Optional<Admin> user = adminRepository.findById(adminId);
		if (user.get().getEmailId() != null) {
			return new ResponseEntity<Guard>(guardService.addGuard(guard), HttpStatus.CREATED);
		} else {
			throw new UserNotFoundException("Not a valid Admin");
		}
	}

	/**
	 * @param name
	 * @return ResponseEntity<List<Guard>>
	 */
	@GetMapping("admin/guard/getGuardByName")
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
	@GetMapping("admin/guard/getGuardById")
	public ResponseEntity<Guard> getGuardById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getGuardById URL is opened");
		LOGGER.info("getGuardById() is initiated");
		return new ResponseEntity<Guard>(guardService.getGuardById(id), HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<Guard>>
	 */
	@GetMapping("admin/guard")
	public ResponseEntity<List<Guard>> getAllGuards() {
		LOGGER.info("getAllGuards URL is opened");
		LOGGER.info("getAllGuards() is initiated");
		return new ResponseEntity<List<Guard>>(guardService.getAllGuards(), HttpStatus.OK);
	}

	/**
	 * @param guard
	 * @return ResponseEntity<Guard>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("admin/guard")
	public ResponseEntity<Guard> deleteGuard(@Valid @RequestBody Guard guard)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("deleteGuard URL is opened");
		LOGGER.info("deleteGuard() is initiated");
		return new ResponseEntity<Guard>(guardService.deleteGuard(guard), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Guard>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("admin/guard/{id}")
	public ResponseEntity<Guard> deleteGuardById(@Valid @PathVariable Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("deleteGuardById URL is opened");
		LOGGER.info("deleteGuardById() is initiated");
		return new ResponseEntity<Guard>(guardService.deleteGuardById(id), HttpStatus.OK);
	}

	/**
	 * @param guardId
	 * @param guardSalary
	 * @return ResponseEntity<Guard>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("admin/guard")
	public ResponseEntity<Guard> updateGuardSalary(@Valid @RequestParam Long guardId,
			@RequestBody GuardSalary guardSalary) throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateGuard URL is opened");
		LOGGER.info("updateGuard() is initiated");
		return new ResponseEntity<Guard>(guardService.updateGuardSalary(guardId, guardSalary), HttpStatus.OK);
	}
	
	
	/**
	 * @param guardId
	 * @param guardShift
	 * @return ResponseEntity<Guard>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("admin/guard/UpdateGuardShift")
	public ResponseEntity<Guard> updateGuardShift(@Valid @RequestParam Long guardId,
			@RequestBody GuardShift guardShift) throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateGuardShift URL is opened");
		LOGGER.info("updateGuardShift() is initiated");
		Optional<Guard> guard = guardRepository.findById(guardId);	
		if(guard != null)
		{
			guard.get().setGuardShifts(guardShift);
			Guard gd = guardRepository.save(guard.get());
			return new ResponseEntity<Guard>(gd, HttpStatus.OK);
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return ResponseEntity<Guard>
	 * @throws UserNotFoundException
	 */
	@PatchMapping("admin/guard/{id}")
	public ResponseEntity<Guard> updateGuardById(@Valid @PathVariable Long id, @RequestParam String oldPassword,
			@RequestParam String newPassword) throws UserNotFoundException {
		LOGGER.info("updateGuardById URL is opened");
		LOGGER.info("updateGuardById() is initiated");
		return new ResponseEntity<Guard>(guardService.updateGuardById(id, oldPassword, newPassword), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<List<Attendance>>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("admin/guard/getGuardAttendanceById")
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
	@GetMapping("admin/guard/getGuardSalariesById")
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
	@GetMapping("admin/guard/getGuardShiftsById")
	public ResponseEntity<GuardShift> getGuardShiftsById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getGuardById URL is opened");
		LOGGER.info("getGuardById() is initiated");
		Guard guard = guardService.getGuardById(id);

		return new ResponseEntity<GuardShift>(guard.getGuardShifts(), HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<Visitor>>
	 */
	@GetMapping("admin/visitor")
	public ResponseEntity<List<Visitor>> getVisitorList() {
		LOGGER.info("getVisitorList URL is opened");
		LOGGER.info("getVisitorList() is initiated");
		return new ResponseEntity<List<Visitor>>(visitorService.getVisitorList(), HttpStatus.OK);
	}

	/**
	 * @param securityAlert
	 * @param adminId
	 * @return ResponseEntity<SecurityAlert>
	 * @throws DuplicateRecordException
	 * @throws MethodArgumentNotValidException
	 * @throws UserNotFoundException
	 */
	@PostMapping("admin/{id}/securityAlert") /// Add To adminRepo
	public ResponseEntity<SecurityAlert> addSecurityAlert(@RequestBody SecurityAlert securityAlert,
			@RequestParam Long adminId)
			throws DuplicateRecordException, MethodArgumentNotValidException, UserNotFoundException {
		LOGGER.info("addSecurityAlert URL is opened");
		LOGGER.info("addSecurityAlert() is initiated");
		Optional<Admin> user = adminRepository.findById(adminId);
		if (user.get().getEmailId() != null) {
			return new ResponseEntity<SecurityAlert>(securityAlertService.addSecurityAlert(securityAlert),
					HttpStatus.CREATED);
		} else {
			throw new UserNotFoundException("Not a valid Admin");
		}
	}

	/**
	 * @return ResponseEntity<List<SecurityAlert>>
	 */
	@GetMapping("admin/securityAlert")
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
	@GetMapping("admin/securityAlert/getSecurityAlertById")
	public ResponseEntity<SecurityAlert> getSecurityAlertById(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getSecurityAlertById URL is opened");
		LOGGER.info("getSecurityAlertById() is initiated");
		return new ResponseEntity<SecurityAlert>(securityAlertService.getSecurityAlertById(id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<SecurityAlert>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("admin/securityAlert/{id}")
	public ResponseEntity<SecurityAlert> deleteSecurityAlertById(@Valid @PathVariable Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("deleteSecurityAlertById URL is opened");
		LOGGER.info("deleteSecurityAlertById() is initiated");
		return new ResponseEntity<SecurityAlert>(securityAlertService.deleteSecurityAlertById(id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param oldMessage
	 * @param newMessage
	 * @return ResponseEntity<SecurityAlert>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PatchMapping("admin/securityAlert/{id}")
	public ResponseEntity<SecurityAlert> updateSecurityAlertMessage(@Valid @PathVariable Long id,
			@Valid @RequestParam String oldMessage, @Valid @RequestParam String newMessage)
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
	@PutMapping("admin/securityAlert")
	public ResponseEntity<SecurityAlert> updateSecurityAlert(@Valid @RequestBody SecurityAlert securityAlert)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateSecurityAlert URL is opened");
		LOGGER.info("updateSecurityAlert() is initiated");
		return new ResponseEntity<SecurityAlert>(securityAlertService.updateSecurityAlert(securityAlert),
				HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<Delivery>>
	 */
	@GetMapping("admin/delivery")
	public ResponseEntity<List<Delivery>> getAllDeliveries() {
		LOGGER.info("getAllDeliveries URL is opened");
		LOGGER.info("getAllDeliveries() is initiated");
		return new ResponseEntity<List<Delivery>>(deliveryService.getDeliveryList(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("admin/delivery/getDeliveryById")
	public ResponseEntity<Delivery> getDeliveryById(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("getDeliveryById URL is opened");
		LOGGER.info("getDeliveryById() is initiated");
		return new ResponseEntity<Delivery>(deliveryService.getDeliveryById(id), HttpStatus.OK);
	}

	/**
	 * @return
	 */
	@GetMapping("admin/domesticHelps")
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
	@GetMapping("admin/domesticHelps/getDomesticHelpById")
	public ResponseEntity<DomesticHelp> getDomesticHelpById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getDomesticHelpById URL is opened");
		LOGGER.info("getDomesticHelpById() is initiated");
		return new ResponseEntity<DomesticHelp>(domesticHelpService.getDomesticHelpById(id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<List<Attendance>>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("admin/domesticHelps/getDomesticHelpAttendanceById")
	public ResponseEntity<List<Attendance>> getDomesticHelpAttendanceById(@Valid @RequestParam Long id)
			throws UserNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getDomesticHelpById URL is opened");
		LOGGER.info("getDomesticHelpById() is initiated");
		DomesticHelp dhelp = domesticHelpService.getDomesticHelpById(id);
		return new ResponseEntity<List<Attendance>>(dhelp.getAttendance(), HttpStatus.OK);
	}

	/**
	 * @param flatDetails
	 * @return ResponseEntity<FlatDetails>
	 * @throws DuplicateRecordException
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("admin/flatDetails")
	public ResponseEntity<FlatDetails> addFlatDetails(@Valid @RequestBody FlatDetails flatDetails)
			throws DuplicateRecordException, MethodArgumentNotValidException {

		LOGGER.info("addFlatDetails URL is opened");
		LOGGER.info("addFlatDetails() is initiated");
		FlatDetails flat = flatDetailsService.addFlatDetails(flatDetails);
		return new ResponseEntity<FlatDetails>(flat, HttpStatus.CREATED);
	}

	/**
	 * @param flatNumber
	 * @return ResponseEntity<FlatDetails>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("admin/flatDetails/getFlatDetailsById")
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
	@GetMapping("admin/owner/flatDetails")
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
	@PutMapping("admin/flatDetails/{flatNumber}")
	public ResponseEntity<FlatDetails> updateFlatDetails(@Valid @PathVariable("flatNumber") Long flatNumber,
			@Valid @RequestBody Owner ownerDetails) throws RecordNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateFlatDetails URL is opened");
		LOGGER.info("updateFlatDetails() is initiated");
		return new ResponseEntity<FlatDetails>(flatDetailsService.updateFlatDetails(flatNumber, ownerDetails),
				HttpStatus.OK);
	}

	/**
	 * @param owner
	 * @param adminId
	 * @return ResponseEntity<Owner>
	 * @throws DuplicateRecordException
	 * @throws UserNotFoundException
	 */
	@PostMapping("admin/{id}/owner")
	public ResponseEntity<Owner> addOwner(@Valid @RequestBody Owner owner, @RequestParam Long adminId)
			throws DuplicateRecordException, UserNotFoundException {
		LOGGER.info("addOwner URL is opened");
		LOGGER.info("addOwner() is initiated");
		Optional<Admin> user = adminRepository.findById(adminId);
		if (user.get().getEmailId() != null) {
			return new ResponseEntity<Owner>(ownerService.addOwner(owner), HttpStatus.CREATED);
		} else {
			throw new UserNotFoundException("Not a valid Admin");
		}

	}

	/**
	 * @param id
	 * @param adminId
	 * @return ResponseEntity<Owner>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("admin/owner/{id}")
	public ResponseEntity<Owner> deleteOwnerById(@Valid @PathVariable Long id, @RequestParam Long adminId)
			throws UserNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("deleteOwnerById URL is opened");
		LOGGER.info("deleteOwnerById() is initiated");
		Optional<Admin> user = adminRepository.findById(adminId);
		if (user.get().getEmailId() != null) {
			Owner owner = ownerService.deleteOwnerById(id);
			return new ResponseEntity<Owner>(owner, HttpStatus.OK);
		} else {
			throw new UserNotFoundException("Not a valid Admin");
		}
	}

	/**
	 * @param owner
	 * @return ResponseEntity<Owner>
	 * @throws UserNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@PutMapping("admin/owner")
	public ResponseEntity<Owner> updateOwner(@Valid @RequestBody Owner owner)
			throws UserNotFoundException, MethodArgumentNotValidException {
		LOGGER.info("updateOwner URL is opened");
		LOGGER.info("updateOwner() is initiated");
		return new ResponseEntity<Owner>(ownerService.updateOwner(owner), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Owner>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 * @throws UserNotFoundException
	 */
	@GetMapping("admin/owner/getOwnerById")
	public ResponseEntity<Owner> getOwnerById(@Valid @RequestParam Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException, UserNotFoundException {

		LOGGER.info("getOwnerById URL is opened");
		LOGGER.info("getOwnerById() is initiated");
		return new ResponseEntity<Owner>(ownerService.getOwnerById(id), HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<Owner>>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("admin/owner/getOwnerList")
	public ResponseEntity<List<Owner>> getOwnerList() throws RecordNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getOwnerList URL is opened");
		LOGGER.info("getOwnerList() is initiated");
		return new ResponseEntity<List<Owner>>(ownerService.getAllOwnerList(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Vehicle>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("admin/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehiclesById(@Valid @PathVariable("id") Long id)
			throws RecordNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getVehiclesById URL is opened");
		LOGGER.info("getVehiclesById() is initiated");
		return new ResponseEntity<Vehicle>(vehicleService.getVehiclesById(id), HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<List<Vehicle>>
	 * @throws RecordNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("admin/vehicles/getAllVehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles()
			throws RecordNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getVehiclesById URL is opened");
		LOGGER.info("getVehiclesById() is initiated");
		return new ResponseEntity<List<Vehicle>>(vehicleService.getAllVehicles(), HttpStatus.OK);
	}
}
