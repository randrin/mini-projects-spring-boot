package com.randrin.roles.based.authorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PublicController {

    @GetMapping("/public")
    public String publicAccess() {
        return "This is the public end point access";
    }
}
