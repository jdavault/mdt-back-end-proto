package com.medtronic.reqauth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class JwtResponse {

    String jwt;
    Long id;
    String username;
    String email;
    List<String> roles;


}
