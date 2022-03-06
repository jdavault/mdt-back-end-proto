package com.medtronic.reqauth.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/public")
public class PublicController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Page";
    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('SALES_REP') or hasRole('ADMIN')")
    public String userAccess() {
        return "Valid User Page";
    }
    @GetMapping("/salesRep")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Sales Rep Page.";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Page.";
    }
}