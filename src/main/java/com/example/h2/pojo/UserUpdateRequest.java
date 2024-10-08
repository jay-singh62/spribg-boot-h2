package com.example.h2.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    @NotBlank
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    @NotBlank
    private String password;
    private String newPassword;
}
