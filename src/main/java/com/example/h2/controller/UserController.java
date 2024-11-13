package com.example.h2.controller;

import com.example.h2.model.User;
import com.example.h2.pojo.*;
import com.example.h2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping()
    public  String test(){
        return "hii bro";
    }
    @PostMapping()
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequest request) {
        return service.createUser(request);
    }

    @DeleteMapping()
    ResponseEntity<User> deleteUser(@RequestBody UserDeleteRequest request) {
        return service.deleteUser(request);
    }

    @PutMapping()
    ResponseEntity<User> updateUser(@RequestBody UserUpdateRequest request) {
        return service.updateUser(request);
    }
}


