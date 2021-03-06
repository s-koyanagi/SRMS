package com.example.srms.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SeminarDTO {

    private int seminarId;
    private String title;
    private String overview;

    private String eventDate;
    private String startedTime;
    private String closedTime;
    private String startedDateTime;
    private String closedDateTime;

    private Date createdDateTime;
    private Date updatedDateTime;
    private Date deletedDateTime;
    private int acceptingFlag;
    private Integer version;

    private int numberOfGuest;

}

