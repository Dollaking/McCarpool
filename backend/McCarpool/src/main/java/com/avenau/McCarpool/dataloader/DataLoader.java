package com.avenau.McCarpool.dataloader;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import com.avenau.McCarpool.models.Comment;
import com.avenau.McCarpool.models.DriverRating;
import com.avenau.McCarpool.models.Post;
import com.avenau.McCarpool.models.User;
import com.avenau.McCarpool.service.CommentService;
import com.avenau.McCarpool.service.DriverRatingService;
import com.avenau.McCarpool.service.PostService;
import com.avenau.McCarpool.service.UserService;


@Component
public class DataLoader implements ApplicationRunner {
	private Log log = LogFactory.getLog(DataLoader.class);
	
	private CommentService commentService;
	private DriverRatingService driverRatingService;
	private PostService postService;
	private UserService userService;
	
	@Autowired
	public DataLoader(CommentService commentService, DriverRatingService driverRatingService, PostService postService,
			UserService userService) {
		super();
		this.commentService = commentService;
		this.driverRatingService = driverRatingService;
		this.postService = postService;
		this.userService = userService;
	}

	@Override
	@Transactional
	@Modifying
	public void run(ApplicationArguments args) throws Exception {
		//Create User
		User aven = new User("dollaking", "password", "Aven", "Au");
		User justin = new User("Masterwarrior", "password", "Justin", "Chau");
		User tony = new User("WangRooney", "password", "Tony", "Wang");
		User jimmy = new User("NuggetMuncher", "password", "Jimmy", "Pham");
		User megan = new User("Meegz", "password", "Megan", "Tang");
		
		userService.save(megan);
		userService.save(jimmy);
		userService.save(tony);
		userService.save(aven);
		userService.save(justin);
		
		Post tonight = new Post(aven, "Maccas Run Tonight?");
		postService.save(tonight);
		
		System.out.println("Find All Users: " + userService.findAll());
		System.out.println("All Posts: " + postService.findAll());
		
	}

}
