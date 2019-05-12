package com.example.srms.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SpeakerInfoDto {

    private int speakerId;
    private int seminarId;
    private String name;
    private String theme;
    private Date startedTime;
    private Date closedTime;
    private Date createdDateTime;
    private Date updatedDateTime;
    private Date deletedDateTime;
    private Integer version;

}
