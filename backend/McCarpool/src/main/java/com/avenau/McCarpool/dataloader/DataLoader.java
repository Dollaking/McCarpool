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
		User aven = new User("Dollaking", "Aven", "Au");
		User justin = new User("Masterwarrior", "Justin", "Chau");
		User tony = new User("WangRooney", "Tony", "Wang");
		User jimmy = new User("NuggetMuncher", "Jimmy", "Pham");
		User megan = new User("Meegz", "Megan", "Tang");
		
		userService.save(megan);
		userService.save(jimmy);
		userService.save(tony);
		userService.save(aven);
		userService.save(justin);
		
		System.out.println("Find All Users: " + userService.findAll());
		
	}

}
