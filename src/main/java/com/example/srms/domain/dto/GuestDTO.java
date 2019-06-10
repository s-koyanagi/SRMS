package com.example.srms.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class GuestDTO {

    private int guestId;
    private int seminarId;
    private String esqId;
    private String name;
    private String priorQuestion;
    private Date createdDateTime;
    private Date updatedDateTime;
    private Date deletedDateTime;
    private Integer version;

}
