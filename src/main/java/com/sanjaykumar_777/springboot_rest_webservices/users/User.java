package com.sanjaykumar_777.springboot_rest_webservices.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sanjaykumar_777.springboot_rest_webservices.posts.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

/*
we cannot use user as a table name in h2
because user is a keyword in h2
 */
@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @JsonProperty("user_name")
    @Size(min = 2,message = "Name should be atleast 2 characters length")
    private String name;
    @JsonProperty("birth_date")
    @Past(message = "The birthdate should always be in past")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    protected User(){

    }

    public User(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
