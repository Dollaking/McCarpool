package com.avenau.McCarpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avenau.McCarpool.models.DriverRating;

@Repository
public interface DriverRatingRepository extends JpaRepository<DriverRating, Integer>{

}
