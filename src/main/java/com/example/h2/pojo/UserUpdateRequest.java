package com.example.h2.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    private String email;
    private String firstname;
    private String lastname;
    private Integer age;
    private String password;
    private String newpassword;
}
