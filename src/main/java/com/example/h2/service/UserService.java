package com.example.h2.service;

import com.example.h2.model.User;
import com.example.h2.pojo.*;
import org.springframework.http.ResponseEntity;


public interface UserService  {
ResponseEntity<User> createUser( UserCreateRequest request);
ResponseEntity<User> deleteUser(UserDeleteRequest request );
ResponseEntity<User> updateUser(UserUpdateRequest request );
LoginResponse  loginUser(LoginRequest request);
}
