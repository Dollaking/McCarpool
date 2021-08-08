package com.avenau.McCarpool.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	private String username;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
	private List<Post> ownedPosts;
	
	@ManyToMany(mappedBy = "participants", cascade = CascadeType.PERSIST)
	private List<Post> participatingPosts;
	
	@OneToMany(mappedBy = "rated", cascade = CascadeType.PERSIST)
	private List<DriverRating> ratingList;
	
	@OneToMany(mappedBy = "rater", cascade = CascadeType.PERSIST)
	private List<DriverRating> ratingsMade;
	
	@OneToMany(mappedBy = "commenter", cascade = CascadeType.PERSIST)
	private List<Comment> commentsMade;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public User(String username, String firstName, String lastName) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ownedPosts = new ArrayList<Post> ();
		this.participatingPosts = new ArrayList<Post> ();
		this.ratingList = new ArrayList<DriverRating> ();
		this.ratingsMade = new ArrayList<DriverRating> ();
		this.commentsMade = new ArrayList<Comment> ();
	}

	public User(String username, String firstName, String lastName, List<Post> ownedPosts,
			List<Post> participatingPosts, List<DriverRating> ratingList, List<DriverRating> ratingsMade,
			List<Comment> commentsMade) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ownedPosts = ownedPosts;
		this.participatingPosts = participatingPosts;
		this.ratingList = ratingList;
		this.ratingsMade = ratingsMade;
		this.commentsMade = commentsMade;
	}



	public int getUserId() {
		return userId;
	}

	public List<Post> getOwnedPosts() {
		return ownedPosts;
	}

	public void setOwnedPosts(List<Post> ownedPosts) {
		this.ownedPosts = ownedPosts;
	}

	public List<Post> getParticipatingPosts() {
		return participatingPosts;
	}

	public void setParticipatingPosts(List<Post> participatingPosts) {
		this.participatingPosts = participatingPosts;
	}

	public List<DriverRating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<DriverRating> ratingList) {
		this.ratingList = ratingList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<DriverRating> getRatingsMade() {
		return ratingsMade;
	}

	public void setRatingsMade(List<DriverRating> ratingsMade) {
		this.ratingsMade = ratingsMade;
	}

	public List<Comment> getCommentsMade() {
		return commentsMade;
	}

	public void setCommentsMade(List<Comment> commentsMade) {
		this.commentsMade = commentsMade;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", ownedPosts=" + ownedPosts + ", participatingPosts=" + participatingPosts
				+ ", ratingList=" + ratingList + ", ratingsMade=" + ratingsMade + ", commentsMade=" + commentsMade
				+ "]";
	}	
	
	

}
