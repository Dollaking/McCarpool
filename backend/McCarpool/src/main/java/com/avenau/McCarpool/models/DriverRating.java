package com.avenau.McCarpool.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DriverRating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driverRatingId;
	private double rating;
	private String review;
	
	@ManyToOne
	private User rater;
	
	@ManyToOne
	private User rated;
	public DriverRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DriverRating(double rating, String review, User rater, User rated) {
		super();
		this.rating = rating;
		this.review = review;
		this.rater = rater;
		this.rated = rated;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public User getRater() {
		return rater;
	}
	public void setRater(User rater) {
		this.rater = rater;
	}
	public User getRated() {
		return rated;
	}
	public void setRated(User rated) {
		this.rated = rated;
	}
	public int getDriverRatingId() {
		return driverRatingId;
	}
	@Override
	public String toString() {
		return "DriverRating [driverRatingId=" + driverRatingId + ", rating=" + rating + ", review=" + review
				+ ", rater=" + rater.getUsername() + ", rated=" + rated.getUsername() + "]";
	}
	
	
}
