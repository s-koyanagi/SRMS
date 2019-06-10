package com.example.srms.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class SpeakerDTO {

    private int speakerId;
    private int seminarId;
    private String name;
    private String theme;
    private Time startedTime;
    private Time closedTime;
    private Date createdDateTime;
    private Date updatedDateTime;
    private Date deletedDateTime;
    private Integer version;

}
