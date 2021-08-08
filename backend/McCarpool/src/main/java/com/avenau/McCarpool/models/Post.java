package com.avenau.McCarpool.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	@ManyToOne
	private User owner;
	private String postContent;
	@ManyToMany
	private List<User> participants;
	@OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
	private List<Comment> comments;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Post( User owner, String postContent) {
		super();
		this.owner = owner;
		this.postContent = postContent;
	}


	public Post(User owner, List<User> participants, List<Comment> comments, String content) {
		super();
		this.owner = owner;
		this.participants = participants;
		this.comments = comments;
		this.postContent = content;
	}

	public int getPostId() {
		return postId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getContent() {
		return postContent;
	}

	public void setContent(String content) {
		this.postContent = content;
	}


	@Override
	public String toString() {
		return "Post [postId=" + postId + ", owner=" + owner.getUsername() + ", postContent=" + postContent + ", participants="
				+ participants + ", comments=" + comments + "]";
	}



	
	
}
