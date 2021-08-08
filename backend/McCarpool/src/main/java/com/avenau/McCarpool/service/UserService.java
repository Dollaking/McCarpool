package com.avenau.McCarpool.service;

import java.util.List;

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
	
	

}
