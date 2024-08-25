package com.sanjaykumar_777.springboot_rest_webservices.versioning;

public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                '}';
    }
}
