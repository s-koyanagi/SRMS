package com.example.srms.web.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SpeakerForm {

    private int speakerId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String theme;
}
