package com.example.srms.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="applicants")
public class ApplicantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicant_id;
    private int seminar_id;
    private String name;
    private String mail_address;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    @Version
    private Integer version;

}
