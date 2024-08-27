package com.sanjaykumar_777.springboot_rest_webservices.jpa;

import com.sanjaykumar_777.springboot_rest_webservices.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
