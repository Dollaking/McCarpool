package com.avenau.McCarpool.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;
	private String commentContent;
	@ManyToOne
	private User commenter;
	@ManyToOne
	private Post post;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(String commentContent, User commenter, User commented) {
		super();
		this.commentContent = commentContent;
		this.commenter = commenter;
	}

	public int getCommentId() {
		return commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentContent=" + commentContent + ", commenter=" + commenter.getUsername()
				+ ", post=" + post + "]";
	}

}
