package com.example.h2.service;

import com.example.h2.model.User;
import com.example.h2.pojo.UserCreateRequest;
import com.example.h2.pojo.UserDeletRequest;
import com.example.h2.pojo.UserUpdateRequest;
import org.springframework.http.ResponseEntity;


public interface UserService  {
ResponseEntity<User> createUser( UserCreateRequest request);
ResponseEntity<User> deletUser(UserDeletRequest request );
ResponseEntity<User> updateUser(UserUpdateRequest request );
}
