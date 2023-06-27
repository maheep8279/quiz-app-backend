package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.Jwtutil.JwtUtil;
import com.auth.entity.LoginResponse;
import com.auth.entity.User;
import com.auth.exception.SequenceException;
import com.auth.model.AuthenticationRequest;
import com.auth.model.AuthenticationResponse;
import com.auth.repository.UserRepo;
import com.auth.service.MyUserDetailsService;
import com.auth.service.SequenceDao;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthorizationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepo repo;

	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private SequenceDao sequenceDao;

	@PostMapping("/register")
	public String showRegister(@RequestBody User user) throws SequenceException {
		long sequenceid = sequenceDao.getNextSequenceId("users");
		System.out.println("*********" + sequenceid + "********");
		user.setId(sequenceid);
		User u = repo.insert(user);
		if (u != null)
			return "Registered Successfully";
		return "Not Registered";
	}

	@PostMapping("/login")
	public LoginResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		LoginResponse response = new LoginResponse();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password ", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

		response.setJwt(jwtTokenUtil.generateToken(userDetails));
		return response;

	}
	
	@GetMapping("/getRole/{email}")
	public User getUserRole(@PathVariable("email") String email) {
	    User userDetails = userDetailsService.loadByUserRole(email);
	    return userDetails;
	}

	@GetMapping("/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {
		AuthenticationResponse response = new AuthenticationResponse();
		try {
			if (token == null) {
				response.setValid(false);
				return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
			} else {
				String token1 = token.substring(7);

				if (jwtTokenUtil.verifyToken(token1)) {

					String name = jwtTokenUtil.extractUsername(token1);
					User user = userDetailsService.loadByUserRole(name);
					response.setName(name);
					response.setRole(user.getRole());
					response.setValid(true);
				} else {
					response.setValid(false);
					return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
