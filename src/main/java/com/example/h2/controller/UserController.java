package com.example.h2.controller;

import com.example.h2.model.User;
import com.example.h2.pojo.UserCreateRequest;
import com.example.h2.pojo.UserDeletRequest;
import com.example.h2.pojo.UserUpdateRequest;
import com.example.h2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping()
   public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request) {
        return service.createUser(request);
    }

    @DeleteMapping()
    ResponseEntity<User> deletUser( @RequestBody UserDeletRequest request){
        return  service.deletUser(request);
    }
    @PostMapping("/update")
    ResponseEntity<User> updateUser( @RequestBody UserUpdateRequest request ){
        return  service.updateUser(request);
    }


}
