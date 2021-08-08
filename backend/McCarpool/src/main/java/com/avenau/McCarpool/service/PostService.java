package com.avenau.McCarpool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avenau.McCarpool.models.Post;
import com.avenau.McCarpool.repository.PostRepository;

@Service
public class PostService {
	
	private PostRepository postRepo;

	@Autowired
	public PostService(PostRepository postRepo) {
		super();
		this.postRepo = postRepo;
	}
	
	public Post findById(int id) {
		return postRepo.findById(id).get();
	}
	
	public Post save(Post post) {
		return postRepo.save(post);
	}
	
	public void deleteById(int id) {
		postRepo.deleteById(id);
	}
	
	public void delete(Post post) {
		postRepo.delete(post);
	}

	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return postRepo.findAll();
	}
	
	

}
