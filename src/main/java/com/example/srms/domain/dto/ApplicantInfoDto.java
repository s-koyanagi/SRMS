package com.example.srms.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ApplicantInfoDto {

    private int seminar_id;
    private String name;
    private String mail_address;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private Integer version;

}
