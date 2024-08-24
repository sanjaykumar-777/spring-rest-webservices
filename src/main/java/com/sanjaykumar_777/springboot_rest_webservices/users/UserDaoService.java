package com.sanjaykumar_777.springboot_rest_webservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    //JPA/Hibernate > Database
    //UserDaoService > Static list
    private static List<User> users = new ArrayList<>();

    /*
    static block - will get executed only once
    when the class if first loaded
     */
    private static int usersCount =0;
    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Sam", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().get();
    }

    public void save(User user){
        user.setId(++usersCount);
        users.add(user);
    }

}
