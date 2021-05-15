package com.marizueva.laboratory.hw6.entities;


public class User {
    public static final User ROMAN = new User("Roman", "Jdi1234");

    String name;
    String password;

    public User(String login, String password) {
        this.name = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
