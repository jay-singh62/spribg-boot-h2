package com.example.h2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "user1")
public class User{
    @Id
    private String email;
    private String firstname;
    private String lastname;
    private Integer age;
    private String password;
    private String newpassword;

}
