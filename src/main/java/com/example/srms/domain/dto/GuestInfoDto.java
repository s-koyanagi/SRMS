package com.example.srms.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class GuestInfoDto {

    private int seminarId;
    private String name;
    private String mailAddress;
    private Date createdTime;
    private Date updatedTime;
    private Date deletedTime;
    private Integer version;

}
