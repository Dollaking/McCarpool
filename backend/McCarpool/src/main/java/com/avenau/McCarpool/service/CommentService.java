package com.avenau.McCarpool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenau.McCarpool.models.Comment;
import com.avenau.McCarpool.repository.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepo;
	
	@Autowired
	public CommentService(CommentRepository commentRepository) {
		super();
		this.commentRepo = commentRepository;
	}
	
	public Comment findById(int id) {
		return commentRepo.findById(id).get();
	}
	
	public Comment save(Comment comment) {
		return commentRepo.save(comment);
	}
	
	public void deleteById(int id) {
		commentRepo.deleteById(id);
	}
	
	public void delete(Comment comment) {
		commentRepo.delete(comment);
	}

}
