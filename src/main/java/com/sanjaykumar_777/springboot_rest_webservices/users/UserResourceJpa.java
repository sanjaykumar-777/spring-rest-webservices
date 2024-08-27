package com.sanjaykumar_777.springboot_rest_webservices.users;

import com.sanjaykumar_777.springboot_rest_webservices.exception.PostNotFoundException;
import com.sanjaykumar_777.springboot_rest_webservices.exception.UserNotFoundException;
import com.sanjaykumar_777.springboot_rest_webservices.jpa.PostRepository;
import com.sanjaykumar_777.springboot_rest_webservices.jpa.UserRepository;
import com.sanjaykumar_777.springboot_rest_webservices.posts.Post;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResourceJpa {
    UserRepository userRepository;
    PostRepository postRepository;

    //constructor injection
    public UserResourceJpa(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    //EntityModel - HATEOAS - Hypermedia as the Engine of Application State
    //WebMvcLinkBuilder
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }
        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        /**
         * ServletUriComponentsBuilder - utility class in Spring that helps in building URI
         * (Uniform Resource Identifier) components based on the current HttpServletRequest
         * (HERE) - /users
         */
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getAllPostOfUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }
        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createNewPost(@PathVariable int id, @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw  new UserNotFoundException("id: "+id);
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{userId}/posts/{postId}")
    public Post retrievePost(@PathVariable int userId, @PathVariable int postId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("id: "+userId);
        }
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new PostNotFoundException("Post not found with id: " + postId);
        }
        return post.get();
    }

}
