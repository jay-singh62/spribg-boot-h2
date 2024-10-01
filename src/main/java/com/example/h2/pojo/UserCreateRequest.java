package com.example.h2.pojo;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserCreateRequest {
    @NotBlank
    @Email
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    @NotBlank
    private String password;
}