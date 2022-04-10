package com.randrin.request.validation.exception.controller;

import com.randrin.request.validation.exception.dto.UserRequest;
import com.randrin.request.validation.exception.entity.User;
import com.randrin.request.validation.exception.exception.UserNotFoundException;
import com.randrin.request.validation.exception.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<User>(userService.registerUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getALlUsers());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.FOUND);
    }
}
