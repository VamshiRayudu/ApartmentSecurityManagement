package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sprint.entities.Admin;
import com.sprint.entities.Guard;
import com.sprint.entities.Owner;
import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.repositories.IAdminRepository;
import com.sprint.repositories.IGuardRepository;
import com.sprint.repositories.IOwnerRepository;
import com.sprint.repositories.IUserRepository;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
@Service
@Transactional
@Primary
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IAdminRepository adminRepository;

	@Autowired
	private IGuardRepository guardRepository;

	@Autowired
	private IOwnerRepository ownerRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public User registerUser(User user) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		List<User> u = userRepository.findByEmailId(user.getEmailId());
		if (u.size() == 0) {
			if (user.getRole() == Role.ADMIN) {
				Admin admin = adminRepository.findByEmailId(user.getEmailId());
				if (admin == null) {
					Admin adm = new Admin();
					adm.setEmailId(user.getEmailId());
					adm.setMobileNumber(user.getMobileNumber());
					adm.setUserName(user.getUserName());
					adm.setPassword(bcryptEncoder.encode(user.getPassword()));
					adm.setRole(user.getRole());
					adm.setName(user.getName());

					user.setPassword(bcryptEncoder.encode(user.getPassword()));
					userRepository.save(user);
					return adminRepository.save(adm);
				} else {
					throw new DuplicateRecordException("User Already Exists");
				}
			} else if (user.getRole() == Role.GUARD) {
				Guard guard = guardRepository.findByEmailId(user.getEmailId());
				if (guard == null) {
					Guard gd = new Guard();
					gd.setEmailId(user.getEmailId());
					gd.setMobileNumber(user.getMobileNumber());
					gd.setUserName(user.getUserName());
					gd.setPassword(bcryptEncoder.encode(user.getPassword()));
					gd.setRole(user.getRole());
					gd.setName(user.getName());

					user.setPassword(bcryptEncoder.encode(user.getPassword()));
					userRepository.save(user);
					return guardRepository.save(gd);
				} else {
					throw new DuplicateRecordException("User Already Exists");
				}
			} else if (user.getRole() == Role.FLATOWNER) {
				Owner ownerCheck = ownerRepository.findByEmailId(user.getEmailId());
				if (ownerCheck == null) {
					Owner owner = new Owner();
					owner.setEmailId(user.getEmailId());
					owner.setMobileNumber(user.getMobileNumber());
					owner.setUserName(user.getUserName());
					owner.setPassword(bcryptEncoder.encode(user.getPassword()));
					owner.setRole(user.getRole());
					owner.setName(user.getName());

					user.setPassword(bcryptEncoder.encode(user.getPassword()));
					userRepository.save(user);
					return ownerRepository.save(owner);
				} else {
					throw new DuplicateRecordException("User already Exists");
				}
			}
		} else {
			throw new DuplicateRecordException("User already Exists");
		}
		return null;
	}

	@Override
	public User Login(String emailId, String password, Role role) {
		// TODO Auto-generated method stub
		if (role == Role.ADMIN) {
			Admin admin = adminRepository.findByEmailId(emailId);
			return admin;

		} else if (role == Role.GUARD) {
			Guard guard = guardRepository.findByEmailId(emailId);
			return guard;

		} else if (role == Role.FLATOWNER) {
			Owner owner = ownerRepository.findByEmailId(emailId);
			return owner;
		}
		return null;
	}

	@Override
	public User Logout(String emailId, String password, Role role) {
		// TODO Auto-generated method stub
		if (role == Role.ADMIN) {
			Admin admin = (Admin) adminRepository.findByEmailId(emailId);
			return admin;
		} else if (role == Role.GUARD) {
			Guard guard = guardRepository.findByEmailId(emailId);
			return guard;
		} else if (role == Role.FLATOWNER) {
			Owner owner = ownerRepository.findByEmailId(emailId);
			return owner;
		}
		return null;
	}

	public User findUser(User user) {

		User dbUser = userRepository.findByEmailId(user.getEmailId()).get(0);
		System.out.println("db user " + dbUser);
		if (dbUser == null)
			throw new RuntimeException("user does nt exist");
		if (!dbUser.getPassword().contentEquals(user.getPassword())) {
			throw new RuntimeException("password mismatch");
		}
		System.out.println("returning dbuser");
		return dbUser;
	}
}
