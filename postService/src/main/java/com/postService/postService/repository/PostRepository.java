package com.postService.postService.repository;


import com.postService.postService.model.Post;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Id> {
}
