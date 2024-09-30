package com.example.h2.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    @NotNull
    private String email;
    private String firstname;
    private String lastname;
    private Integer age;
    @NotNull
    private String password;
    private String newPassword;
}
