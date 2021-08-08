package com.avenau.McCarpool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenau.McCarpool.models.User;
import com.avenau.McCarpool.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;

	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public User findById(int id) {
		return userRepo.findById(id).get();
	}
	
	public User findByUsername(String username) {
		Optional<User> requestedUser = userRepo.findByUsername(username);
		System.out.println("FIND BY USERNAME: " + requestedUser);
		System.out.println("IS EMPTY " + requestedUser.isEmpty());
		if (requestedUser.isEmpty()) {
			return null;
		}
		return requestedUser.get();
	}
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User save(User user) {
		return userRepo.save(user);
	}
	
	public void deleteById(int id) {
		userRepo.deleteById(id);
	}
	
	public void delete(User user) {
		userRepo.delete(user);
	}
	
	public boolean userExist(String username) {
		User user = this.findByUsername(username);
		if (user == null) {
			return false;
		}
		return true;
	}
	
	

}
