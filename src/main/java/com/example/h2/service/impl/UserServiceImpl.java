package com.example.h2.service.impl;

import com.example.h2.common.PassBasedEnc;
import com.example.h2.model.User;
import com.example.h2.pojo.*;
import com.example.h2.repo.UserRepo;
import com.example.h2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo repo;
    @Value("${app.salt}")
    String salt;

    @Override
    public ResponseEntity<User> createUser(UserCreateRequest request) {
        User existingUser = repo.findByEmail(request.getEmail());
        if (existingUser != null) {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setAge(request.getAge());
        String encryptedPas = PassBasedEnc.generateSecurePassword(request.getPassword(), salt);
        newUser.setPassword(encryptedPas);
        return new ResponseEntity<>(repo.save(newUser), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> deleteUser(UserDeleteRequest request) {
        String encryptedPas = PassBasedEnc.generateSecurePassword(request.getPassword(), salt);
        User userinfo = repo.findByEmailAndPassword(request.getEmail(), encryptedPas);
        if (userinfo != null) {
            repo.deleteById(request.getEmail());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<User> updateUser(UserUpdateRequest request) {
        String encryptedPas = PassBasedEnc.generateSecurePassword(request.getPassword(), salt);
        User userinfo = repo.findByEmailAndPassword(request.getEmail(), encryptedPas);
        if (userinfo != null) {
            if (request.getLastName() != null) {
                userinfo.setLastName(request.getLastName());
            }
            if (request.getFirstName() != null) {
                userinfo.setFirstName(request.getFirstName());
            }
            if (request.getAge() != null) {
                userinfo.setAge(request.getAge());
            }
            if (request.getNewPassword() != null) {
                String newEncryptedPas = PassBasedEnc.generateSecurePassword(request.getNewPassword(), salt);
                userinfo.setPassword(newEncryptedPas);
            }
            return new ResponseEntity<>(repo.save(userinfo), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        String encryptedPas = PassBasedEnc.generateSecurePassword(request.getPassword(), salt);
        User userinfo = repo.findByEmailAndPassword(request.getEmail(), encryptedPas);
        if (userinfo != null) {
            response.setStatus(true);
        } else {
            response.setStatus(false);
        }
        return response;
    }
}

