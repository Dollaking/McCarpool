package com.avenau.McCarpool.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avenau.McCarpool.dto.LoginDTO;
import com.avenau.McCarpool.dto.RegisterDTO;
import com.avenau.McCarpool.models.User;
import com.avenau.McCarpool.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
	private UserService userService;

	@Autowired
	public AuthenticationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	/*
	 * Very Basic Login, #TODO Implement Spring Security
	 */
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody LoginDTO loginDetails){
		Map<String, String> response = new HashMap<String, String> ();
		
		User requestedUser = userService.findByUsername(loginDetails.getUsername());
		if (loginDetails.getUsername().equals("") || loginDetails.getPassword().equals("")) {
			response.put("status", "failed");
			response.put("error", "Please enter a username or password!");
		} else if (requestedUser == null) {
			response.put("status", "failed");
			response.put("error", "Incorrect Username or Password!");
		} else if (!loginDetails.getPassword().equals(requestedUser.getPassword()) ) {
			response.put("status", "failed");
			response.put("error", "Incorrect Username or Password!");
		} else {
			response.put("status", "success");
			response.put("error", "");
			response.put("username", loginDetails.getUsername());
		}
		
		return response;	
	}
	
	@PostMapping("/register")
	public Map<String, String> register(@RequestBody RegisterDTO registerDetails){
		Map<String, String> response = new HashMap<String, String> ();
		if (userService.userExist(registerDetails.getUsername())) {
			response.put("status", "failed");
			response.put("error", "User already exist!");
		} else if (registerDetails.getPassword() != registerDetails.getConfirmPassword()) {
			response.put("status", "failed");
			response.put("error", "Password and Confirm Password do not match!");
		} else if (registerDetails.getUsername() == "") {
			response.put("status", "failed");
			response.put("error", "You must have a password!");
		} else {
			response.put("status", "success");
			response.put("error", "");
		}
		
		return response;
		
	}
	
	

}
