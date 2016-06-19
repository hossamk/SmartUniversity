package com.smartuniversitygp.smartuniversity.helper;

/**
 * Created by hossam on 6/19/16 .
 */
public class User {
    String firstName;
    String lastName;
    String email;
    String type;
    String token;

    public User(String firstName, String lastName, String email, String type, String token) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
