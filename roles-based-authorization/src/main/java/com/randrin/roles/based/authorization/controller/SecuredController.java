package com.randrin.roles.based.authorization.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SecuredController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "This is the admin end point access";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "This is the user end point access";
    }

    @GetMapping("/admin-user")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String adminUserAccess() {
        return "This is the admin-user end point access";
    }
}
