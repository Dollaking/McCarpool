package com.avenau.McCarpool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenau.McCarpool.models.DriverRating;
import com.avenau.McCarpool.repository.DriverRatingRepository;

@Service
public class DriverRatingService {
	private DriverRatingRepository driverRatingRepo;
	
	@Autowired
	public DriverRatingService(DriverRatingRepository driverRatingRepo) {
		super();
		this.driverRatingRepo = driverRatingRepo;
	}
	
	public DriverRating findById(int id) {
		return driverRatingRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		driverRatingRepo.deleteById(id);
	}
	
	public void delete(DriverRating driverRating) {
		driverRatingRepo.delete(driverRating);
	}
	
	public DriverRating save(DriverRating driverRating) {
		return driverRatingRepo.save(driverRating);
	}

}
