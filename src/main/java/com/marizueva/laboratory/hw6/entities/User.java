package com.marizueva.laboratory.hw6.entities;


public class User {
    public static final User ROMAN = new User("Roman", "Jdi1234");

    String login;
    String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
