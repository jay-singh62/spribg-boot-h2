package com.example.h2.service.impl;

import com.example.h2.model.User;
import com.example.h2.pojo.UserCreateRequest;
import com.example.h2.pojo.UserDeletRequest;
import com.example.h2.pojo.UserUpdateRequest;
import com.example.h2.repo.UserRepo;
import com.example.h2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo repo;

    @Override
    public ResponseEntity<User> createUser(UserCreateRequest request) {
        User user= repo.findByEmail(request.getEmail());
        if (user!=null){
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
        User useR=new User();
        useR.setEmail(request.getEmail());
        useR.setFirstname(request.getFirstname());
        useR.setLastname(request.getLastname());
        useR.setAge(request.getAge());
        useR.setPassword(request.getPassword());
        User userobj= repo.save(useR);
        return new ResponseEntity<>(userobj,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<User> deletUser(UserDeletRequest request) {
        User userinfo = repo.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (userinfo != null){
            repo.deleteById(request.getEmail());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<User> updateUser(UserUpdateRequest request ) {
        User userinfo = repo.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (userinfo!=null ) {
            userinfo.setLastname(request.getLastname());
            userinfo.setFirstname(request.getFirstname());
            userinfo.setAge(request.getAge());
            userinfo.setNewpassword(request.getNewpassword());
            return new ResponseEntity<>( repo.save(userinfo), HttpStatus.OK);
        }
              return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

