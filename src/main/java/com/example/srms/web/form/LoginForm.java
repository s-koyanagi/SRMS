package com.example.srms.web.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginForm {

    @NotEmpty
    private String esqId;
    @NotEmpty
    private String password;
}
