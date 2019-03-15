package com.example.srms.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="seminars")
public class Seminar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seminar_id;
    private String title;
    private String overview;
    private Date started_at;
    private Date closed_at;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private int accepting_flag;
    @Version
    private Integer version;

}
