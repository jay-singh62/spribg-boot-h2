package com.example.h2.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDeleteRequest {
    private String email;
    private String password;

}
