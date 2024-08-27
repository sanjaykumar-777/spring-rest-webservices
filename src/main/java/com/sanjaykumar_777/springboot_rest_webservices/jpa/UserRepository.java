package com.sanjaykumar_777.springboot_rest_webservices.jpa;

import com.sanjaykumar_777.springboot_rest_webservices.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
