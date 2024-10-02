package com.example.h2.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDeleteRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
