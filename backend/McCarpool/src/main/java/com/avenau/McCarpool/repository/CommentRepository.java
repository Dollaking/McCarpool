package com.avenau.McCarpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avenau.McCarpool.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
