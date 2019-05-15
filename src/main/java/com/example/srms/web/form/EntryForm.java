package com.example.srms.web.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class EntryForm {

    @NotEmpty
    private String seminarId;
    private String priorQuestion;

}
