package com.medtronic.reqauth.models;

import java.util.Set;

public class SignupRequest {
    String username;
    String password;
    String email;
    Set<String> role;

    public Set<String> getRole() {
        return role;
    }


    public String getEmail() {
        return email;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

}
