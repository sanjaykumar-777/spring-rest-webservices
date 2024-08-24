package com.sanjaykumar_777.springboot_rest_webservices.users;

import com.sanjaykumar_777.springboot_rest_webservices.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id"+id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);
        /**
         * ServletUriComponentsBuilder - utility class in Spring that helps in building URI
         * (Uniform Resource Identifier) components based on the current HttpServletRequest
         * (HERE) - /users
         */
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
