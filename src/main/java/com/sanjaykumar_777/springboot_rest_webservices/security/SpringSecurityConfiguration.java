package com.sanjaykumar_777.springboot_rest_webservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //1. All requests should be authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        //2. If a request is not authenticated, a web page is shown
        http.httpBasic(Customizer.withDefaults());
        //3 . remove CSRF(Cross-Site Request Forgery) - POST, PUT
        //csrf is currently depricated
        //update it later
        http.csrf().disable();
        return http.build();

    }
}
