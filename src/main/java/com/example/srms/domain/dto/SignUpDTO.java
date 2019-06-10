package com.example.srms.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDTO {

    private String esqId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String password;
    private String maskPassword;
    private int isRegister;
}
