package com.example.srms.web.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SeminarForm {

    private int seminarId;
    @NotEmpty
    private String title;
    @NotEmpty
    private String eventDate;
    @NotEmpty
    private String startedTime;
    @NotEmpty
    private String closedTime;
//    @NotEmpty
//    private int acceptingFlag;

}
