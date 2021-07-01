package com.sprint.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sprint.JwtTokenUtil;
import com.sprint.entities.JwtRequest;
import com.sprint.entities.JwtResponse;
import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.services.IUserService;
import com.sprint.services.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private IUserService userService;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		User userDb = userService.Login(authenticationRequest.getEmail(), authenticationRequest.getPassword(), authenticationRequest.getRole());
		
		if(userDb == null)
		{
			throw new UserNotFoundException("Not a Valid User");
		}
		
		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
		System.out.println("============================================");
		System.out.println("jwt request " + authenticationRequest.getEmail());
		System.out.println("============================================");

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

		System.out.println(userDetails);
		
		final String token = jwtTokenUtil.generateToken(userDetails);

		System.out.println("token" + token);

		return ResponseEntity.ok(new JwtResponse(token,userDb.getId()));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		return ResponseEntity.ok(userService.registerUser(user));
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ResponseEntity<User> loginUser(@RequestParam String emailId, @RequestParam String password,
			@RequestParam Role role) throws Exception {
		return ResponseEntity.ok(userService.Login(emailId, password, role));
	}

	private void authenticate(String emailId, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(emailId, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}