package com.example.srms.web.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class IndexForm {

    @NotEmpty
    private String userId;
    @NotEmpty
    private String password;
}
