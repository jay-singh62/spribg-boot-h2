package com.example.h2.repo;

import com.example.h2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
 User findByEmail(String email);
 User findByEmailAndPassword(String email ,String password);

}
